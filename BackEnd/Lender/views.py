from syslog import LOG_EMERG
from django.contrib.auth.decorators import login_required
from django.http.response import JsonResponse

from .models import LenderInfo
from Borrower.models import BorrowerProfileInfo

@login_required
def lender_profile(request):
    res = {}
    if request.method == "GET":
        curr_user = request.user.username
        res = list(LenderInfo.objects.filter(username = curr_user).values('first_name' , 
        'last_name' , 'email' , 'account_number' , 'upi_id'
        ))
        return JsonResponse(res , safe=False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )

@login_required
def get_borrowers(request):
    res = {}
    if request.method == "GET":
        curr_user = request.user.id
        res = list(BorrowerProfileInfo.objects.filter(lender__id = curr_user).values('first_name' , 
        'last_name' , 'email' , 'contact_no' , 'username'
        ))
        return JsonResponse(res , safe=False , status = 200)
    else:
        res['msg'] = "method not allowed"
        return JsonResponse(res ,safe = False ,  status = 405 )
