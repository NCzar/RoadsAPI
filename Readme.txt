Instructions if run on Eclipse

If downloading from Github, please follow the below instructions 

1.  In Eclipse go to File -> Import -> Git -> Projects from Git 
2.  Enter the project's URI: https://github.com/NCzar/RoadsAPI
3.  Select branch master and choose the Directory you want to download it to
4.  Go to File -> Import -> General -> Existing Projects into workspace
5.  In the Select root directory browse to the downloaded Git project folder and click Finish
6.	You should now be able to see the Project RoadConnector in the Eclipse project explorer
  

Title
	
RoadConnections: This API gives you information about road connectivity between any two cities

URL

/connected

Params

origin
destination

Required

origin=[String]
destination=[String]

Success Response

Content: { yes/no}

Sample Call

http://localhost:8080/connected?origin=Boston&destination=Philadelphia
	
Testing
	
Unit Tests are provided on RoadConnectorTest class. Both URL validation are route validation are tested

Notes

This API reads edges from a text file which has data about roads between two cities.If one city can be connected to another using the data in the city.txt file, the API will return yes. Otherwise it will return no.