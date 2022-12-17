import json
import pandas as pd
import numpy as np

file_obj = open('alcohol_outlets.json')

data_dict = json.load(file_obj)

# Latitude: 28.650400 / N 28° 39' 1.44''
# Longitude: 77.237200 / E 77° 14' 13.92''

# for curr_row in data_dict['data']:
#     lat = curr_row[-2]
#     longi = curr_row[-1]
#     print(lat , longi)

# k=== sqrt(n)

from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler #for better classification


from sklearn.datasets import load_iris #dataset

#for testing
from sklearn.metrics import confusion_matrix
from sklearn.metrics import f1_score
from sklearn.metrics import accuracy_score

df = pd.read_csv('new_dataset.csv')
# Create feature and target arrays
X = df.iloc[: , :]
Y = df.iloc[: , :]

# Split into training and test set
X_train, X_test, y_train, y_test = train_test_split(
			X, Y, test_size = 0.2, random_state=42)

knn = KNeighborsClassifier(n_neighbors=7)

knn.fit(X_train, y_train)

# Predict on dataset which model has not seen before
print(knn.predict(X_test))

file_obj.close()