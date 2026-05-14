# Student Management System

A Spring Boot REST API project for managing students.
## Tech Stack

- Java

- Spring Boot

- Spring Data JPA

- Postgresql

- Maven
  
- ## Features

- Add Student

- Update Student

- Delete Student

- Get Student By ID

- Get All Students
  ## Validation Used

- `@NotBlank`

- `@Email`

- `@Valid`

Example:

```java

@NotBlank(message = "Name cannot be empty")

private String name;

@Email(message = "Invalid email format")

private String email;

```
  
  ## API Endpoints

| Method | Endpoint |

|--------|----------|

| GET | /students |

| GET | /students/{id} |

| POST | /students |

| PUT | /students/{id} |

| DELETE | /students/{id} |
## Run Project

1. Clone repository

2. Configure MySQL

3. Run Spring Boot applicationi
