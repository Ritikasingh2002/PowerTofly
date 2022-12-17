"""Lender URL Configuration
"""
from django.urls import path , include

from .views import lender_profile , get_borrowers

urlpatterns = [
    path('Profile/', lender_profile),
    path('GetBorrowers/', get_borrowers),

]
