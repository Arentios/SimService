# Simulator Service
Java Simulator for a population of pseudo people

This is a Spring based REST service suite running JCS designed to interact with the Python based service in the same directory

Handles more advanced data processing and in depth simulation than the Python service

Note that the service assumes that data is either fetched from the Python service as a first step or has been generated and seeded on the Java side (NYI), in the future a pre-load or schedule based load might be added as well as the potential for an in-memory DB

Also TBD is better error reporting to the user

Sample service calls, assuming running locally on port 8080

http://localhost:8080/SimService/person/fetch #Fetches data from the Python web service and loads into the cache

http://localhost:8080/SimService/person/get #Gets all data and returns in JSON form

http://localhost:8080/SimService/person/get/475 #Returns data for a specific person in JSON form

