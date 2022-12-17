"""Payment URL Configuration
"""
from django.urls import path 
from .views import add_money , add_account , get_balance , decency_score , kavach_call , get_money , temp , transaction_history , add_suspect_list , get_suspect_list ,get_lender_info

urlpatterns = [
    path('AddAccount/' , add_account),
    path('AddMoney/' , add_money),
    path('GetBalance/' , get_balance),
    path('KavachCall/' , kavach_call),
    path('DecencyScore/' , decency_score , name = 'decency_score'),
    path('getMoney/<str:lender_ph>/' , get_money),
    path('temp/' , temp),
    path('TransactionHistory/' , transaction_history),
    path('AddSuspectList/' , add_suspect_list),
    path('GetSuspectList/' , get_suspect_list)  ,
    path('GetLenderInfo/' , get_lender_info)
    # path('GetTransactionInfo/' , get_transaction_info)    

]
