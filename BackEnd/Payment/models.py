from datetime import datetime
from statistics import mode
from django.db import models
from Lender.models import LenderInfo
from django.contrib.auth.models import User

class UserAccounts(models.Model):
    amount =  models.FloatField()
    user = models.ForeignKey(LenderInfo, on_delete=models.CASCADE , related_name='userinfo') 

class Transactions(models.Model):
    lender = models.ForeignKey(User, on_delete=models.CASCADE , related_name='Transactioninfo') 
    recipient = models.ForeignKey(User, on_delete=models.CASCADE , related_name='Transactionuserinfo') 
    transaction_amount = models.BigIntegerField(default= 0)
    status = models.CharField(default= "Pending" , max_length= 200)
    lat = models.DecimalField(max_digits=18, decimal_places=15 , default=0.0)
    lon =  models.DecimalField(max_digits=18, decimal_places=15 , default=0.0)
    timestamp = models.DateTimeField(auto_now_add= True)

class SuspectList(models.Model):
    lat = models.DecimalField(max_digits=10, decimal_places=7)
    lon =  models.DecimalField(max_digits=10, decimal_places=7)
    borrower = models.ForeignKey(User, on_delete=models.CASCADE , related_name='borrowerinfo') 
    user =  models.ForeignKey(User, on_delete=models.CASCADE , related_name='userinfo') 
    timestamp = models.DateTimeField(auto_now_add= True)
    amount = models.CharField(max_length=200 , default= "NULL")