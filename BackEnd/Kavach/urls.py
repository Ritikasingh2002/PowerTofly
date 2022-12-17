"""Kavach URL Configuration
"""
from django.contrib import admin
from django.urls import path , include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('KavachAuth/', include('KavachAuth.urls')),
    path('Lender/', include('Lender.urls')),
    path('Borrower/', include('Borrower.urls')),
    path('Payment/', include('Payment.urls')),

]
