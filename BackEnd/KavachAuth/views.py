from urllib import request
from django.http.response import JsonResponse
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
from django.contrib.auth import authenticate, login , logout 

#----------Custom models import ----------------#
from Lender.models import LenderInfo
from Borrower.models import BorrowerProfileInfo

#---------dependency import --------------#
import json
import hashlib
#---------------------------------------------#

def register_lender(request):
    res = {} #final response
    if request.method == 'POST':
        data = json.loads(request.body)
        username = data['username']
        first_name = data['first_name']
        last_name = data['last_name']
        email = data['email'] 
        password = data['password']
        contact_no = data['contact_no']
        upi_id = data['upi_id']
        account_number = data['account_number']
        check_user = User.objects.filter(username = username).exists()

        if check_user:
            res['msg'] = 'User already exists return to login'
            return JsonResponse(res ,safe=False, status = 400)

        user = User.objects.create_user(username = username  , email = email , password = password , first_name = first_name , last_name = last_name)
        user.save()

        # custom user creation
        encoded = username.encode()
        hash_object = hashlib.sha256(encoded)
        wallet_addr = hash_object.hexdigest()
        LenderInfo.objects.create(
            id = user.id,
            username = username,
            first_name = first_name,
            last_name = last_name,
            contact_no = contact_no,
            email = email,
            user_id = user.id,
            wallet_addr = wallet_addr,
            upi_id = upi_id,
            account_number = account_number
        )
        
        res['user'] = list(LenderInfo.objects.filter(username = username).values('id' , 'username' ,  'email' , 'wallet_addr' , 'upi_id'))
        res['msg'] = "registration success"
        return JsonResponse(res , safe=False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )

#---------------------------------------------#

@login_required
def register_borrower(request):
    res = {} #final response
    if request.method == 'POST':
        data = json.loads(request.body)
        username = data['username']
        first_name = data['first_name']
        last_name = data['last_name']
        email = data['email'] 
        password = data['password']
        contact_no = data['contact_no']
        account_number = data['account_number']
        address = data['address']
        # lon = data['lon']
        # lat = data['lat']
        check_user = User.objects.filter(username = username).exists()

        if check_user:
            res['msg'] = 'User already exists return to login'
            return JsonResponse(res ,safe=False, status = 400)

        user = User.objects.create_user(username = username  , email = email , password = password , first_name = first_name , last_name = last_name , is_staff = True)
        user.save()

        # custom user creation
        encoded = username.encode()
        hash_object = hashlib.sha256(encoded)
        wallet_addr = hash_object.hexdigest()
        BorrowerProfileInfo.objects.create(
            id = user.id,
            username = username,
            first_name = first_name,
            last_name = last_name,
            contact_no = contact_no,
            email = email,
            lender_id = request.user.id,
            user_id = user.id,
            wallet_addr = wallet_addr,
            account_number = account_number,
            address = address,
            # lat = lat , 
            # lon = lon
        )
        
        res['user'] = list(BorrowerProfileInfo.objects.filter(username = username).values('id' , 'username' ,  'email' , 'wallet_addr'))
        res['msg'] = "Borrower registration success"
        return JsonResponse(res , safe=False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )
        
#----------------------------------------------#

def custom_login(request):
    res = {}
    if request.method == 'POST':
        if 'HTTP_AUTHORIZATION' in request.META:
            data = json.loads(request.body)
            username = data['username']
            password = data['password']
            user = User.objects.filter(username = username).exists()
            if user:
                user = authenticate(username=username, password=password)
                if user is not None:
                    if user.is_active:
                        login(request, user)
                        lender = User.objects.get(username = username)
                        request.session['user_id'] =  lender.id
                        request.session['user_name'] = lender.username
                    else:
                        res['msg'] = "not an active user"
                        return JsonResponse(res , safe= False , status = 401)
                else:
                    res['msg'] = "Wrong Credentials!"
                    return JsonResponse(res , safe=False , status = 401)
            else:
                res['msg'] = "user does not exists unauthorized!"
                return JsonResponse(res , safe=False , status = 401)
            res['msg'] = "login success"
            # res['sessionid'] = request.session.session_key
            return JsonResponse(res , safe=False , status = 200)
        else:
            res['msg'] = "Bad request"
            return JsonResponse(res , safe= False , status = 400)
    else:
        res['msg'] = "Bad Request"
        return JsonResponse(res , safe= False , status = 401)

#---------------------------------------------#

@login_required
def custom_logout(request):
    res = {}
    if('HTTP_COOKIE' in request.META):
        logout(request)
        res['msg'] = "logout success"
        return JsonResponse(res, safe=False)
    else:
        res['msg'] = "return to signup page/ unauthorized" 
        return JsonResponse(res, safe=False , status = 401)
