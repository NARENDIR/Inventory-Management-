# Inventory Management Microservice

This microservice handles inventory management for a retail store. It provides REST APIs for CRUD operations on inventory items and includes batch processing functionality for bulk updates.

## Objective

The objective of this microservice is to enhance proficiency in developing microservices using Spring Boot, integrating various types of databases, designing and documenting RESTful APIs, and implementing batch processes within a microservice architecture.

## Features

- **REST API**: Provides endpoints for adding, updating, deleting, and retrieving inventory items.
- **Database Integration**: Integrates with a relational database using Spring Data JPA for persistence.
- **Batch Processing**: Implements a Spring Batch job to process CSV files for bulk updates.
- **Validation and Exception Handling**: Includes input validation and proper exception handling for the REST API.
- **Documentation**: Documents the REST API using Swagger.

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/NARENDIR/project.git

Navigate to the project directory:
cd inventory-management

Build the project using Maven:
mvn clean install

Run the application:
java -jar target/inventory-management-microservice.jar

API Endpoints
Adding a new inventory item
URL: /inventory/add
Method: POST


Request Body:

{
  "name": "Product A",
  "description": "Description for Product A",
  "stockLevel": 100
}
Response:
Status Code: 201 Created
Response Body:

{
  "id": 1,
  "name": "Product A",
  "description": "Description for Product A",
  "stockLevel": 100
}


Batch Processing
To trigger batch processing for bulk updates, use the following endpoint:

URL: /inventory/batch-process
Method: POST
Request Body: CSV file containing inventory updates.


API Documentation
The API is documented using Swagger. You can access the Swagger UI at http://localhost:8080/swagger-ui.html.

Technologies Used
Spring Boot
Spring Data JPA
Spring Batch
MySQL 
Swagger
