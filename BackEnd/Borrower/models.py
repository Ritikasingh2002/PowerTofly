from django.db import models
from Lender.models import LenderInfo
# import uuid
from django.contrib.auth.models import User

class BorrowerProfileInfo(models.Model):
    # id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    first_name = models.CharField(max_length=200 , default="NUll")
    last_name = models.CharField(max_length=200 , default="NUll")
    username = models.CharField(max_length=200 , unique=True , default="NULL")
    email = models.EmailField(max_length=200 , default="NULL")
    contact_no = models.CharField(max_length=200 , default="NUll" , unique=True)
    borrower_img = models.URLField(default="NULL" , unique = False)
    wallet_addr = models.CharField(max_length= 256 , default="NULL")
    account_number = models.CharField(max_length= 256 , default="NULL")
    lat = models.CharField(max_length= 256 , default="NULL")
    lon = models.CharField(max_length= 256 , default="NULL")
    address = models.CharField(max_length= 256 , default="NULL")
    lender =models.ForeignKey(LenderInfo, on_delete=models.CASCADE , related_name='lenderinfo') 
    user = models.ForeignKey(User, on_delete=models.CASCADE , related_name='defaultinfo') 
