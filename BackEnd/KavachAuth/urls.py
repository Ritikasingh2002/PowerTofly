"""Authentication URL Configuration
"""
from django.urls import path , include

from .views import register_lender , custom_login  , custom_logout , register_borrower

urlpatterns = [
    path('accounts/', include('allauth.urls')),
    path('Register/Lender/', register_lender),
    path('Register/Borrower/', register_borrower),
    path('Login/Lender/', custom_login),
    path('Logout/', custom_logout),
]
