# Reactive Spring Boot Application with H2 Database

This is a sample project demonstrating how to build a reactive Spring Boot application with an H2 database.

## Prerequisites
To run this application, you will need:

- Java 17 or later installed on your machine
- Maven installed on your machine

## Getting Started
1. Clone this repository to your local machine
2. Open a terminal and navigate to the project root directory
3. Run the following command to start the application:
    ```bash
      mvn spring-boot:run
    ```
4. Open a web browser and navigate to http://localhost:8080 to see the home page of the application

## Database
This application uses an H2 in-memory database. 
The database is initialized with some sample data at application startup. 

## Endpoints

GET /pricing - Return the applicable price for the specified request


