Instructions if run on Eclipse

If downloaded from Github, please follow the below instructions before first run if you see gradle dependency issues 
1.	Save the zipped project folder on one of the clipse workspaces
2.	Navigate to the project location on Command prompt and run gradle init. This regenerates the build.gradle file
3.	Copy the build.gradle contents in the Github repo to the just generated build.gradle file
4.	Run gradle build on Command Prompt
5.	Now the project should be free of any library import/gradle dependency issues

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
