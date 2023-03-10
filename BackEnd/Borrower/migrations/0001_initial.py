# Generated by Django 2.2 on 2022-04-03 10:15

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('Lender', '0001_initial'),
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='BorrowerInfo',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(default='NULL', max_length=200, unique=True)),
                ('first_name', models.CharField(default='NUll', max_length=200)),
                ('last_name', models.CharField(default='NUll', max_length=200)),
                ('email', models.EmailField(default='NULL', max_length=200)),
                ('contact_no', models.CharField(default='NUll', max_length=200, unique=True)),
                ('borrower_img', models.URLField(default='NULL')),
                ('lender', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='lenderinfo', to='Lender.LenderInfo')),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='defaultinfo', to=settings.AUTH_USER_MODEL)),
            ],
        ),
    ]
