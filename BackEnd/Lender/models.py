from statistics import mode
from django.db import models
from django.contrib.auth.models import User


class LenderInfo(models.Model):
    id = models.IntegerField(primary_key=True, serialize=False)
    first_name = models.CharField(max_length=200 , default="NUll")
    last_name = models.CharField(max_length=200 , default="NUll")
    username = models.CharField(max_length=200, default="NULL" , unique= True )
    contact_no = models.CharField(max_length=200 , default="Null" , unique=True)
    email = models.EmailField(max_length=254)
    wallet_addr = models.CharField(max_length= 256 , default="NULL")
    account_number = models.CharField(max_length= 256 , default="NULL")
    upi_id =  models.CharField(max_length= 256 , default="NULL")
    user = models.ForeignKey(User, on_delete=models.CASCADE , related_name='user_model') 
