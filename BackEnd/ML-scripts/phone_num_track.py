# import phonenumbers
# number = "+916386845062"

# from phonenumbers import geocoder
# from phonenumbers import carrier

# ch_number = phonenumbers.parse(number, "CH") ## ch == country history
# print(ch_number)
# print(geocoder.description_for_number(ch_number, "en"))

# service_provider = phonenumbers.parse(number, "RO")
# print(carrier.name_for_number(service_provider, "en")) #service provider

from twilio.twiml.voice_response import VoiceResponse

def fun():
    vr = VoiceResponse()
    vr.say('Hello!')