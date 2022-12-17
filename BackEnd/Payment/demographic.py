import pandas as pd
from math import radians, cos, sin, asin, sqrt

def dist(lat1, long1, lat2, long2):
    """
    Replicating the  Haversine Distance formula 
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
    # km is the ditance between the two points in km
    return km * 1000

def find_nearest(lat, longi):
    liquor_shops = pd.read_csv('Payment/new_dataset.csv')
    # print(liquor_shops.head())
    liquor_shops=liquor_shops.rename(columns = {'Latitude':'lat','Longitude':'lon'})
    # print(liquor_shops.info())
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

