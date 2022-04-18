# common-log-service
Service to allow users to write on a shared log file.

# Description
Service to create a log message and save in csv file(/logs/spring-boot-logger.csv)

# Dependencies
- Java 11

# Building The Service
The service can be built with the following command using maven from CMD or windows powershell:
- -X -e clean install

# Running the service 
From any application that allows the testing of web APIs execute the url in localhost
- localhost:8080/managed-logs with Http POST method
- and body:
{
    "message":"Hello world"
}

