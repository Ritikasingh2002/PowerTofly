"""Borrower URL Configuration
"""
from pkgutil import ImpImporter
from django.urls import path , include

from .views import borrower_img_upload 

urlpatterns = [
    path('Upload/<str:borrower_id>/', borrower_img_upload),
]
