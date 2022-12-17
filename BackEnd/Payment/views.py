#----------Custom models import ----------------#
from Lender.models import LenderInfo
from .models import SuspectList, UserAccounts , Transactions
from Borrower.models import BorrowerProfileInfo
#---------dependency import --------------#

from django.http.response import JsonResponse
from django.contrib.auth.decorators import login_required
import json
from .demographic import find_nearest

#--------------------------------------------------#

@login_required
def add_account(request):
    res = {}
    if request.method == 'GET':
        check_user = UserAccounts.objects.filter(user_id = request.user.id,).exists()
        if not check_user:
            UserAccounts.objects.create(
                user_id = request.user.id,
                amount = 0.00
            )
            res['msg'] = 'User Kavach account Added'
        else:
            res['msg'] = 'User Account Exists!'
        return JsonResponse(res , safe= False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )


#--------------------------------------------------#

@login_required
def add_money(request):
    res = {}
    if request.method == 'POST':
        data = json.loads(request.body)
        amount = round(float(data['amount']) , 2)
        check_user = UserAccounts.objects.filter(user_id = request.user.id,).exists()
        
        if not check_user:
            res['msg'] = 'User Account Do not Exist'
            return JsonResponse(res , safe = False , status = 405)

        query = UserAccounts.objects.filter(user_id = request.user.id )
        q = list(query.values('amount'))
        # print(q[0]['amount'])
        new_amount = amount + q[0]['amount']
        query.update(amount = new_amount)
        res['msg'] = 'User account balance updated'
        return JsonResponse(res , safe= False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )       

#--------------------------------------------------#

@login_required
def get_balance(request):
    res = {}
    if request.method == 'GET':
        query = UserAccounts.objects.filter(user_id = request.user.id )
        q = list(query.values('amount'))
        res['amount'] = q[0]['amount']
        return JsonResponse(res , safe= False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )     

@login_required
def decency_score(request):
    res = {}
    if request.method == 'POST':
        data = json.loads(request.body)
        lat = data['lat']
        lon = data['lon']
        threshold = data['range'] # range of observation in km
        res_list = find_nearest(lat, lon)
        print(res_list)
        nearest_liquour_shop = res_list[0]
        nearest_liquor_shop_city = res_list[1]
        nearest_liquor_shop_state = res_list[2]
        nearest_distance = res_list[3]
        decency_score = 0.99

        if(nearest_distance <= threshold):
            per = nearest_distance / threshold    
            decency_score = per
            res['nearest_liquour_shop'] =  nearest_liquour_shop
            res['nearest_liquor_shop_city'] = nearest_liquor_shop_city
            res['nearest_liquor_shop_state'] = nearest_liquor_shop_state

        res['decency_score'] = round(decency_score * 100 , 2) 
        if(nearest_distance > threshold):
            res['nearest_liquour_shop'] = "No liquor Shop Found !"

        return JsonResponse(res , safe = False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )     

#----------twilio-----------------#
from django.http import  HttpResponse
from twilio.twiml.voice_response import VoiceResponse 

def kavach_call(request):
    res = {}
    if request.method == 'POST':
        resp = VoiceResponse()
        resp.say('Hello this is Kavach')
        resp.say('Please Enter Your Lender Phone number and press #')
        resp.gather(
            action = 'https://kavach-amex.herokuapp.com/Payment/GetLenderInfo/',
            finish_on_key='#',
            timeout=20,
        )
        # print(resp.body.Digits)
        resp.say('Thanks Your money request has been sent')
        res['msg'] = 'call done!'
        return HttpResponse(str(resp) , content_type='text/xml')
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )   

def get_lender_info(request):
    str1 = request.body
    new_str = str1.decode("utf-8")
    l = new_str.split('&')
    print(l)
    lender_phone_num = l[14][7:]
    vr = VoiceResponse()
    lender = list(LenderInfo.objects.filter(contact_no = lender_phone_num).values('id'))
    if len(lender) == 0:
        vr.say("Please Enter Correct Lender Phone number")
    else:
        url = 'https://kavach-amex.herokuapp.com/Payment/getMoney/' + str(lender_phone_num) + '/'
        print(url)
        vr.say('Please Enter The amount and press #')
        vr.gather(
            action = url,
            finish_on_key='#',
            timeout=20,
        )
    return HttpResponse(str(vr), content_type='text/xml')
# Twilio will make a request to that url and it 
# will include a Digits parameter in the body of the request. 
def get_money(request , lender_ph):
    res = {}
    str1 = request.body
    # str1 = b'AccountSid=AC5764b7b81fa5154a587348b83e51abfb&ApiVersion=2010-04-01&CallSid=CA0b66c59730db4ae389b57aa6dd047990&CallStatus=in-progress&Called=%2B17659994360&CalledCity=&CalledCountry=US&CalledState=IN&CalledZip=&Caller=%2B916386845062&CallerCity=&CallerCountry=IN&CallerState=&CallerZip=&Digits=300&Direction=inbound&FinishedOnKey=&From=%2B916386845062&FromCity=&FromCountry=IN&FromState=&FromZip=&To=%2B17659994360&ToCity=&ToCountry=US&ToState=IN&ToZip=&msg=Gather+End'
    new_str = str1.decode("utf-8") 
    # print(new_str)
    l = new_str.split('&')
    print(l)
    caller = l[17][10:]
    amt = l[14][7:]
    print(caller , amt)
    borrower_phone = caller
    amount = amt
    lender = list(BorrowerProfileInfo.objects.filter(lender__contact_no = lender_ph).values('lender_id'))
    recipient = list(BorrowerProfileInfo.objects.filter(contact_no = borrower_phone).values('user_id'))
    vr = VoiceResponse()
    if len(recipient) == 0:
        vr.say('Sorry , This Number is not registered with KAVACH')
    elif len(lender) == 0 :
        vr.say('Sorry , You are not assigned this Lender')
    else:
        # print(lender , recipient)
        lender = lender[0]['lender_id']
        recipient = recipient[0]['user_id']
        print(lender , recipient)
        lat = 28.732028480754575
        lon =  77.47652774781864 
        Transactions.objects.create(
            lender_id = lender,
            recipient_id = recipient,
            transaction_amount = amount,
            lat = lat,
            lon = lon,
        )
        vr.say('Thanks Your money request has been sent')
    return HttpResponse(str(vr), content_type='text/xml')
 
def temp(request):
    res = {}
    borrower_phone = "6386845062"
    amount = "300"
    print(borrower_phone)
    lender = list(BorrowerProfileInfo.objects.filter(contact_no = borrower_phone).values('lender_id'))[0]['lender_id']
    recipient = list(BorrowerProfileInfo.objects.filter(contact_no = borrower_phone).values('user_id'))[0]['user_id']
    print(lender , recipient)
    lat = 28.731891116809447
    lon = 77.47724033070612
    Transactions.objects.create(
        lender_id = lender,
        recipient_id = recipient,
        transaction_amount = amount,
        lat = lat,
        lon = lon
    )
    res['msg'] = "Request Sent to the lender"
    return JsonResponse(res ,safe = False ,  status = 200 )    


#------------------------------------------TRANSACTION PORTION---------------------------#

def transaction_history(request):
    res = {}
    if request.method == 'GET':
        lender = request.user.id
        # print(lender)
        q = list(Transactions.objects.filter(lender_id = lender , status = "Pending").values('id' , 'recipient_id',
        'recipient_id__username' , 'transaction_amount' , 'timestamp').order_by
        ('-timestamp'))
        q1 = list(Transactions.objects.filter(lender_id = lender , status = "Accepted").values('id' , 'recipient_id' ,'recipient_id__username' , 'transaction_amount', 'timestamp').order_by
        ('-timestamp'))
        q2 = list(Transactions.objects.filter(lender_id = lender , status = "Rejected").values('id' , 'recipient_id' ,'recipient_id__username' , 'transaction_amount', 'timestamp').order_by
        ('-timestamp'))
        res['failed_transactions'] = q2
        res['accepted_transactions'] = q1
        res['pending_transactions'] = q
        return JsonResponse(res , safe= False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 ) 

#------------------------------Request Reject -- > suspect List --------------#

def add_suspect_list(request):
    res = {}
    if request.method == 'POST':
        data = json.loads(request.body)
        transaction_id = data['id']
        borrower_id = data['borrower_id']
        requested_money = data['money']
        Transactions.objects.filter(id = transaction_id).update(status = 'Rejected')
        SuspectList.objects.create(
            user_id = request.user.id,
            lat = data['lat'],
            lon = data['lon'],
            borrower_id = borrower_id,
            amount = requested_money
        )
        res['msg'] = "Successfully added to suspect list"
        return JsonResponse(res , safe= False , status = 200)
    else:
        res['msg'] = "method not allowed"   
        return JsonResponse(res ,safe = False ,  status = 405 ) 

def get_suspect_list(request):
    res = {}
    if request.method == 'GET':
        q = list(SuspectList.objects.filter(user_id = request.user.id).values('borrower__username' , 'timestamp' , 'amount').order_by('-timestamp'))
        res['suspect_list'] = q
        return JsonResponse(res , safe = False , status = 200)
    else:
        res['msg'] = "method not allowed"   
        return JsonResponse(res ,safe = False ,  status = 405 ) 

# def get_transaction_info(request):
#     res = {}
#     if request.method == 'POST':
#         data = json.loads(request.body)
#         transaction_id = data['id']
#         q = list(Transactions.objects.filter(id = transaction_id).values('lat' , 'lon'))
#         print(q)
#         res = {}
#         return JsonResponse(res , safe = False , status = 200)
#     else:
#         res['msg'] = "method not allowed"   
#         return JsonResponse(res ,safe = False ,  status = 405 ) 