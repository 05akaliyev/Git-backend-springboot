# Nurse Management Backend Project

## Overview
This project involves building a complete backend system for managing nurses, including CRUD operations, database integration, and continuous integration testing. The development progresses through multiple phases, starting from basic static API implementation to a fully functional backend connected to a database.

---

## Project Phases

### Part 3: Introduction to Backend Development
- **Objective**: Develop static endpoints using Spring Boot without database storage.
- **Features**:
  - Return static JSON data for:
    - All registered nurses.
    - Nurse login validation.
    - Search for nurses by name.
  - Test the API endpoints using Postman.
- **Group Tasks**:
  - Create individual branches for each team member to implement features.
  - Integrate all features into a common repository.
- **Deliverables**:
  - Technical documentation with individual and group progress.
  - Postman tests to validate the API.

---

### Part 4: Backend with Database Integration
- **Objective**: Extend the backend to interact with a MySQL database using Hibernate ORM.
- **Features**:
  - Design a logical database model using MySQL Workbench.
  - Generate the database schema from Spring Boot entities.
  - Implement endpoints to fetch data directly from the database:
    - List all nurses.
    - Validate nurse login.
    - Search nurses by name.
- **Group Tasks**:
  - Test with local databases individually.
  - Configure a centralized database for group testing.
- **Deliverables**:
  - Technical documentation detailing the database design and implementation.
  - Global repository link and Postman tests for verification.

---

### Part 5: Backend CRUD Operations
- **Objective**: Complete the CRUD functionality for the `Nurse` entity and set up a Continuous Integration pipeline.
- **Features**:
  - Implement CRUD endpoints:
    - Create, read, update, and delete nurses.
  - Configure CI with GitHub Actions to automate testing.
  - Document the entire project.
- **Group Tasks**:
  - Collaborate on completing the API.
  - Test endpoints with Postman.
- **Deliverables**:
  - Finalized global repository with CI setup.
  - Postman tests for all CRUD operations.

---

## Setup

### Prerequisites
- Java 17 or higher.
- Maven.
- MySQL.

### Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/your-repository.git
   cd your-repository
   ```
2. **Database Configuration**:
   Update the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

---

## Usage

### Main Endpoints
- **Static Data (Part 3)**:
  - `GET /nurses` - List all nurses.
  - `POST /nurses/login` - Validate login.
  - `GET /nurses/{name}` - Search by name.
- **Database Integration (Part 4)**:
  - Same endpoints, now connected to the database.
- **CRUD Operations (Part 5)**:
  - `POST /nurses` - Create a nurse.
  - `GET /nurses/{id}` - Get nurse by ID.
  - `POST /nurses/update` - Update nurse data.
  - `DELETE /nurses/{id}` - Delete nurse.

### Postman Tests
Import the provided Postman collection to validate the endpoints.
