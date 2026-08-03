# DevPrep API

## Overview

DevPrep API is a RESTful API built with **Java** and **Spring Boot** that helps developers prepare for technical interviews. It allows users to create, manage, filter, and retrieve programming interview questions through a clean and well-structured REST API.

This project was developed to practice backend development concepts such as layered architecture, DTOs, validation, pagination, exception handling, and API documentation.

---

## Features

* Create interview questions
* Retrieve a question by ID
* List all questions with pagination
* Update existing questions
* Delete questions
* Filter questions by difficulty
* Filter questions by topic
* Retrieve a random interview question
* Request validation
* Global exception handling
* Interactive API documentation with Swagger/OpenAPI

---

## Technologies

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Jakarta Validation
* Swagger / OpenAPI
* Maven

---

## Project Structure

```
src
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
└── service
```

The project follows a layered architecture:

* **Controller** – Handles HTTP requests.
* **Service** – Contains business logic.
* **Repository** – Handles database access.
* **DTOs** – Separate API requests and responses from entities.
* **Entity** – Represents database tables.

---

## API Endpoints

| Method | Endpoint                             | Description                    |
| ------ | ------------------------------------ | ------------------------------ |
| POST   | `/questions`                         | Create a new question          |
| GET    | `/questions/{id}`                    | Get a question by ID           |
| GET    | `/questions`                         | List all questions (paginated) |
| PUT    | `/questions/{id}`                    | Update a question              |
| DELETE | `/questions/{id}`                    | Delete a question              |
| GET    | `/questions/difficulty/{difficulty}` | Filter questions by difficulty |
| GET    | `/questions/topic/{topic}`           | Filter questions by topic      |
| GET    | `/questions/random`                  | Retrieve a random question     |

---

## Pagination

The listing endpoints support pagination using Spring's `Pageable`.

Example:

```
GET /questions?page=0&size=10
```

You can also paginate filtered results:

```
GET /questions/difficulty/EASY?page=0&size=5

GET /questions/topic/java?page=0&size=5
```

---

## Swagger Documentation

After starting the application, access the interactive API documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Running the Project

### Clone the repository

```bash
git clone https://github.com/your-username/devprep-api.git
```

### Navigate to the project

```bash
cd devprep-api
```

### Configure the database

Update your `application.properties` with your PostgreSQL credentials.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/devprep
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run the application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

## Author

Arthur de Lara Zilli

Backend Developer Student focused on Java and Spring Boot.
