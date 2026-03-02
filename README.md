# 🏋️ Fitness App — Backend

A Spring Boot REST API backend for a fitness tracking application, featuring JWT-based authentication, JPA data persistence, and auto-generated API documentation via Swagger UI.

---

## 🚀 Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 4.0.2 |
| Language | Java 21 |
| Security | Spring Security + JWT (jjwt 0.13.0) |
| Persistence | Spring Data JPA + Hibernate |
| Database | MySQL |
| Validation | Spring Boot Validation |
| API Docs | SpringDoc OpenAPI (Swagger UI) |
| Utilities | Lombok, Jackson |
| Build Tool | Maven |

---

## 📋 Prerequisites

- Java 21+
- Maven 3.8+
- MySQL 8.0+

---

## ⚙️ Setup & Configuration

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd fitness-app
   ```

2. **Configure the database**

   Update `src/main/resources/application.properties` (or `application.yml`) with your MySQL credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/fitness_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Configure JWT secret**

   ```properties
   jwt.secret=your_secret_key_here
   jwt.expiration=86400000
   ```

4. **Build the project**
   ```bash
   mvn clean install
   ```

5. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The server will start at `http://localhost:8080`.

---

## 📖 API Documentation

Once the app is running, visit:

```
http://localhost:8080/swagger-ui.html
```

All endpoints are documented and testable directly from the Swagger UI.

---

## 🔐 Authentication

This API uses **JWT (JSON Web Token)** authentication.

1. Register or log in via the `/auth` endpoints to receive a token.
2. Include the token in all subsequent requests as a Bearer token:

   ```
   Authorization: Bearer <your-token>
   ```

---

## 🗂️ Project Structure

```
fitness-app/
├── src/
│   ├── main/
│   │   ├── java/com/project/fitness/
│   │   │   ├── config/         # Security & app configuration
│   │   │   ├── controller/     # REST controllers
│   │   │   ├── model/          # JPA entities
│   │   │   ├── repository/     # Spring Data repositories
│   │   │   ├── service/        # Business logic
│   │   │   └── security/       # JWT filters & utilities
│   │   └── resources/
│   │       └── application.properties
│   └── test/                   # Unit & integration tests
└── pom.xml
```

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 🛠️ Build for Production

```bash
mvn clean package -DskipTests
java -jar target/fitness-app-0.0.1-SNAPSHOT.jar
```

---

## 📝 License

This project is currently unlicensed. Add a `LICENSE` file to define usage terms.

