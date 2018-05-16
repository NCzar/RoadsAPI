Instructions if run on Eclipse

If downloaded from Github, the below instructions would help you to run it on eclipse
1.	Save the zipped project folder on one of the eclipse workspaces
2.	Go to File -> Import -> General -> Projects from Folder or Archive and then select the folder in the Eclispe workspace
3.  Click Finish and the project would appear on Package Explorer

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
