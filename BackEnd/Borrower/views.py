from django.http.response import JsonResponse

#----------Custom models import ----------------#
from Borrower.models import BorrowerProfileInfo

#---------dependency import --------------#

import os
import cloudinary
import cloudinary.uploader

#-----------------------------------------------------------------#
def allowed_file(filename):
    ALLOWED_EXTENSIONS = { 'png', 'jpg', 'jpeg'}
    return '.' in filename and \
           filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS



def borrower_img_upload(request , borrower_id):
    res = {}
    cloudinary.config( 
    cloud_name = os.environ.get("cloud_name"),
    api_key = os.environ.get("api_key"), 
    api_secret = os.environ.get('api_secret')
    )
    # print(request.FILES)
    if request.FILES:
        files = request.FILES
        for f in files:
            if allowed_file(files[f].name):
                upload_result = cloudinary.uploader.upload(files[f])    
                url = upload_result['url']
                borrower = BorrowerProfileInfo.objects.filter(id = borrower_id).update(borrower_img=url)
                # print(curr_feed[0].id)
                res['msg'] = "file upload success"
                res['upload_url'] = url
                print(url)
                return JsonResponse(res , safe=False , status = 200)
            else:
                res['msg'] = "only .png , .jpg , .jpeg allowed"
                return JsonResponse(res , safe= False , status = 401)
    res['msg'] = "file upload failed"
    return JsonResponse(res , safe=False , status = 400)

