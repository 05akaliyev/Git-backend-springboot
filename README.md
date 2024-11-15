# CRUD Backend Project

## Overview
This project is a simple backend system to manage CRUD (Create, Read, Update, Delete) operations for "Nurses". It also includes basic Continuous Integration (CI) to ensure code quality.

## Features
- **CRUD Operations**:
  - Create a nurse.
  - Read nurse details by ID or username.
  - Update nurse details (username, password, or both).
  - Delete a nurse by ID.
- **Continuous Integration (CI)**:
  - Runs tests on code changes.

## Setup
### Prerequisites
- **Java 17** or higher
- **Maven**
- **MySQL** or another database

### Steps
1. **Clone the repo**:
   ```bash
   git clone https://github.com/yourusername/your-repository-name.git
   cd your-repository-name
   ```
2. **Configure Database**:
   Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## Usage
### Endpoints
- **Create**: `POST /nurses`
- **Read by ID**: `GET /nurses/{id}`
- **Read by Username**: `GET /nurses/{name}`
- **Update**: `POST /nurses/update`
- **Delete**: `DELETE /nurses/{id}`

### Sample JSON
```json
{
  "id": 1,
  "user": "UpdatedUser",
  "password": "UpdatedPassword"
}
```

## Contact
Questions? Contact [Your Name] at [your.email@example.com].

