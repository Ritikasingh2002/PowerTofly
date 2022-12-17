import pandas as pd

from math import radians, cos, sin, asin, sqrt

# Latitude: 28.650400 / N 28° 39' 1.44''
# Longitude: 77.237200 / E 77° 14' 13.92''

#current location of the borrower
# 28.748631095773547, 77.28731215022809
# lat1 = 28.650400
# long1=  77.237200

lat1 = 12.972442
long1 =  77.580643

def dist(lat1, long1, lat2, long2):
    """
    Replicating the  Haversine Distance fromula 
    """
    # convert decimal degrees to radians 
    lat1, long1, lat2, long2 = map(radians, [lat1, long1, lat2, long2])
    # haversine formula 
    
    dlon = long2 - long1 
    dlat = lat2 - lat1 
    
    a = sin(dlat/2)**2 + cos(lat1) * cos(lat2) * sin(dlon/2)**2
    c = 2 * asin(sqrt(a)) 
    # Radius of earth in kilometers is 6371
    km = 6371* c
    # km is the ditance between the two points
    return km

liquor_shops = pd.read_csv('new_dataset.csv')
# print(liquor_shops.head())
liquor_shops=liquor_shops.rename(columns = {'Latitude':'lat','Longitude':'lon'})
# print(liquor_shops.info())

def find_nearest(lat, longi):
    distances = liquor_shops.apply(
        lambda row: dist(lat, longi, row['lat'], row['lon']), 
        axis=1)

    print(distances[: :])
    res = 6371
    for i in distances[: : ]:
        res = min( i , res)
    res = round(res , 2)
    nearest_liquor_shop = liquor_shops.loc[distances.idxmin(), 'Name']
    nearest_liquor_shop_city = liquor_shops.loc[distances.idxmin(), 'City']
    nearest_liquor_shop_state = liquor_shops.loc[distances.idxmin(), 'State']
    return [ nearest_liquor_shop , nearest_liquor_shop_city , nearest_liquor_shop_state, res ]

res_list = find_nearest(lat1, long1)
nearest_liquour_shop = res_list[0]
nearest_liquor_shop_city = res_list[1]
nearest_liquor_shop_state = res_list[2]
nearest_distance = res_list[3]
threshold = 100 # max req dis in km
decency_score = 0.99
print(nearest_liquour_shop , nearest_distance)

if(nearest_distance < threshold):
    per = nearest_distance / threshold    
    decency_score = per

print(decency_score* 100)