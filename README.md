# timetravel
Project Title
Space Time Travel Machine where an api is exposed where the Travel Details of an individual is submitted.

Getting Started
The Project is built as a Spring Boot Application. The code can be imported in any of the IDEs.


Prerequisites
a) The Project requires a JDK version of 1.8
b) PostMan can be used to post Request to the application. (Integration Tests are also available for the same)
c) MySQL having schema time_travel (Integration Tests will use the embedded H2)


Start Up Steps:

The Application can be started by running the main Program in SpaceTimeTravelApplication.java
This will startup the embedded tomcat and deploy the application as jar into the tomcat.
Once the Application is up, the exposed API's can be used.

In the postman:
a) Url to be used: http://localhost:8080/spaceTimeTravel/submitTravelDetails
b) Operation : Post
C) Type : application/json
d) Sample Request :

Example One:
Request:
{
	"pgi":"AI123",
	"place":"Test",
	"travelDate":"1999-01-01 22:55:11"
}

Successful Response:
{
    "statusMsg": "Travel Details have been successfully updated"
}

*travelDate accepts the following pattern yyyy-MM-dd HH:mm:ss
*All the fields are required fields and does not allow nullables

Example Two:

If the same Request posted in Example One is posted again:
Request
{
	"pgi":"AI123",
	"place":"Test",
	"travelDate":"1999-01-01 22:55:11"
}


Response:

{
    "timestamp": "2018-07-24T22:57:36.046+0000",
    "status": 409,
    "error": "Conflict",
    "message": "The Pgi has already a travel plan for the same destination and at the same Date.",
    "path": "/spaceTimeTravel/submitTravelDetails"
}

Unit Tests:
Basic Unit Tests for Major Classes

Integration Test:

SpaceTimeTravelIntegrationTest.java is the Integration Test which starts the application and does an end to end flow using the H2 Database.

Swagger :
Swagger Yaml file is Space_Time_Swagger.yaml
The Swagger html can be viewed by Bringing up the application and hitting following urls:
a) http://localhost:8080/swagger-ui.html (for Swagger html)
b) http://localhost:8080/v2/api-docs


Built With
a)Spring Boot
b) JPA
c) MySQL
d) H2
e) Swagger 2.0
f) Spring fox (for Swagger document Generation)





Versioning
Github is the version control tool used for the Project

Author
Puspanjali Pradhan


