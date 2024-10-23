
# Book Author Management System

## Overview

This project is a Book Author Management System developed using Spring Boot. It demonstrates the use of Spring Data JPA for data persistence, Hibernate ORM for object-relational mapping, and MySQL as the database. The application allows users to manage authors and their books, showcasing various JPA mappings, dynamic query methods, and pagination.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Database Setup](#database-setup)
- [Application Configuration](#application-configuration)
- [Key Features](#key-features)
- [Data JPA Mappings](#data-jpa-mappings)
- [API Documentation](https://documenter.getpostman.com/view/30415721/2sAY4rE4xT)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used

- **Spring Boot** - Framework for building the application
- **Spring Data JPA** - Data access framework for working with JPA
- **Hibernate ORM** - Object-relational mapping tool
- **MySQL** - Database for storing application data
- **Postman** - Tool for testing APIs

## Database Setup

1. Install MySQL and create a database named `book_author_db`.
2. Set up your MySQL user with appropriate permissions.

## Application Configuration

Configure your `application.properties` file in the `src/main/resources` directory to connect to your MySQL database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/book_author_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Key Features

- Create, Read, Update, and Delete (CRUD) operations for authors and books.
- Dynamic query methods for advanced data retrieval.
- Sorting and pagination capabilities for managing large datasets.
- One-to-One, One-to-Many, Many-to-One, and Many-to-Many relationships using JPA.

## Data JPA Mappings

This application demonstrates various types of JPA mappings:

- **One-to-One Mapping**: A single author can have one biography.
- **One-to-Many Mapping**: An author can have multiple books.
- **Many-to-One Mapping**: Many books can be associated with a single author.
- **Many-to-Many Mapping**: Books can be associated with multiple genres.

## API Documentation

For detailed API documentation, you can refer to the Postman documentation [here](link-to-your-postman-documentation).

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/book-author-management.git
   ```

2. Navigate to the project directory:

   ```bash
   cd book-author-management
   ```

3. Build the application using Maven:

   ```bash
   ./mvnw clean install
   ```

4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

5. Access the application at `http://localhost:8080`.

## Contributing

Feel free to fork the repository and submit pull requests. For any issues or suggestions, open an issue in the repository.

## License

This project is licensed under the MIT License.
