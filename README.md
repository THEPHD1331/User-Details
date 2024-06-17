# User Details 
An application in Spring Boot consisting of two APIs - Registering User and Display User Details by Username.

## How to run
- Install jdk-17 or above in the system.
- Open this project in any Java suitable IDE and let all the dependencies download.
- Configure datasource (In my case MySQL) info in application.properties file inside resource folder.
```
spring.datasource.url= jdbc:mysql://localhost:3306/<db-name>
spring.datasource.username= <username>
spring.datasource.password= <password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql= true
```
- After completing above steps run the main file named UserDetailsApplication.java

# Snapshots
1. Secured API Endpoints with basic security


![marker-secure](https://github.com/THEPHD1331/User-Details/assets/126282296/baf8998c-5d1f-4750-bcf7-e4335f90d1d4)


2. Register User(/api/user/register) and Get User By Username(/api/user/fetch) APIs

   
![marker-swagger](https://github.com/THEPHD1331/User-Details/assets/126282296/c49aa131-dd61-42d5-8c0a-1fcc6ac7999b)


3. Request Body format for /api/user/register POST method

   
![marker-swagger-reqBody](https://github.com/THEPHD1331/User-Details/assets/126282296/6f1e9d68-6042-4487-b68d-cda0a81d899d)


4. Response format for /api/user/register POST method


![marker-swagger-respBody](https://github.com/THEPHD1331/User-Details/assets/126282296/70a00c48-ffc7-4859-a6d4-8931f29ddbba)

5. Request Parameter for /api/user/fetch GET method


![marker-swagger-getnamereq](https://github.com/THEPHD1331/User-Details/assets/126282296/f3176dea-0856-4c8e-984f-cb0195a8b683)


6. Response format for /api/user/fetch GET method

   
![marker-swagger-getnamersp](https://github.com/THEPHD1331/User-Details/assets/126282296/0f33d632-61f2-4652-a08e-0bfc69b15e43)


7. Test Cases for Service layer of Application


![marker-serTest](https://github.com/THEPHD1331/User-Details/assets/126282296/eaaf1e2a-6b9c-4f52-acde-47f16037b624)

8. Test Cases for Controller layer of Application

   
![marker-conTest](https://github.com/THEPHD1331/User-Details/assets/126282296/16f80a23-d6ce-4115-81d1-15789fa5150b)
