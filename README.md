# Task Management Application

This is a web-based task management application developed with **Spring Boot**, **PostgreSQL**, and **Docker**. It allows you to create, update, and delete tasks, which are stored in a PostgreSQL database. The application follows **Clean Code** and **Clean Architecture** principles.

---

## Features

- **Create tasks**: Add new tasks with a name, priority, and status.
- **Update tasks**: Modify the name or status (completed/not completed) of an existing task.
- **Delete tasks**: Remove tasks that are no longer needed.
- **Web interface**: A simple and user-friendly browser-based interface.
- **Database**: Persistent storage in PostgreSQL.
- **Docker**: Ready-to-use configuration to run the application and database in Docker containers.

---

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17**: [Download and install JDK 17](https://openjdk.org/projects/jdk/17/).
- **Maven**: [Download and install Maven](https://maven.apache.org/download.cgi).
- **Docker**: [Download and install Docker](https://www.docker.com/products/docker-desktop).
- **Docker Compose**: Included with Docker Desktop.

---

## Project Setup

### 1. Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/your-username/task-management-app.git
cd task-management-app
```

### 2. Set Up the Database

The application uses **PostgreSQL** as its database. You can run the database in a Docker container using the provided `docker-compose.yml` file.

#### Run PostgreSQL with Docker

1. Ensure Docker is running.
2. Run the following command in the project's root directory:

   ```bash
   docker-compose up -d
   ```

   This will start a PostgreSQL container in the background.

3. Verify that the container is running:

   ```bash
   docker ps
   ```

   You should see a container named `task-management-db`.

### 3. Configure the Application

The application is configured to connect to the PostgreSQL database. Ensure the `application.properties` file has the following configuration:

```properties
# Datasource Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
spring.datasource.username=postgres
spring.datasource.password=password

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

## Running the Application

### 1. Build the Project

Build the project using Maven:

```bash
mvn clean install
```

### 2. Run the Application

Run the application with the following command:

```bash
mvn spring-boot:run
```

The application will be available at: [http://localhost:8080](http://localhost:8080).

---

## Using the Application

### Web Interface

1. **Create a task**:
   - Enter the task name and select a priority (Low, Normal, Urgent).
   - Click "Add Task".

2. **Update a task**:
   - Modify the task name or check the box to change its status.
   - Click "Update".

3. **Delete a task**:
   - Click "Delete" to remove a task.

### Accessing the Database

You can access the PostgreSQL database using tools like **pgAdmin** or **DBeaver**.

- **Host**: `localhost`
- **Port**: `5432`
- **Database**: `taskdb`
- **User**: `postgres`
- **Password**: `password`

---

## Running with Docker

If you prefer to run the application in a Docker container, follow these steps:

### 1. Build the Application Image

Build the Docker image for the application:

```bash
docker build -t task-management-app .
```

### 2. Run the Application and Database

Run the application and database together using Docker Compose:

```bash
docker-compose up -d
```

The application will be available at: [http://localhost:8080](http://localhost:8080).

---

## Project Structure

```
task-management-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/taskmanagement/
│   │   │       ├── domain/            # Entities and enums
│   │   │       ├── application/       # Use cases and services
│   │   │       ├── infrastructure/    # Repositories and configurations
│   │   │       ├── presentation/      # Controllers and views
│   │   │       └── TaskManagementApplication.java
│   │   └── resources/
│   │       ├── static/                # Static files (CSS, JS)
│   │       ├── templates/             # Thymeleaf templates
│   │       └── application.properties # Application configuration
│   └── test/                          # Unit and integration tests
├── docker-compose.yml                 # Docker Compose configuration
├── Dockerfile                         # Dockerfile for the application
└── pom.xml                            # Maven configuration
```

---

## Technologies Used

- **Spring Boot**: Framework for developing Java applications.
- **PostgreSQL**: Relational database.
- **Docker**: Containers for the application and database.
- **Thymeleaf**: Template engine for the web interface.
- **Maven**: Dependency management and project build tool.

---

## Contributing

If you'd like to contribute to this project, follow these steps:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/new-feature`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

---

## License

This project is licensed under the GNU License. See the [LICENSE](LICENSE) file for details.

Thank you for using the Task Management Application! 😊

---

### Additional Notes

- If you encounter any issues, check the application or database logs.
- Ensure ports `8080` (application) and `5432` (PostgreSQL) are available on your machine.
