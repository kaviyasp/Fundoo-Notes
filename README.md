# 📒 Fundoo Notes Backend

A robust, enterprise-grade backend system built using **Spring Boot** for managing notes with authentication, caching, messaging, and batch processing capabilities.

---

> **Note:**  
> The complete source code for this project is available in the `dev` branch.  
> The `main` branch contains only project overview and documentation.

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Security (JWT)
* Spring Data JPA (Hibernate)
* MySQL
* Redis (Caching & Token Storage)
* RabbitMQ (Async Messaging)
* ActiveMQ (JMS)
* Spring Cache
* Spring Batch (Excel Processing)
* Docker

---

## 🏗️ Architecture

* Client → Controller → DTO → Service → Repository → Database

---

## 📌 Use Case Implementation (UC1 – UC16)

### 🔹 Phase 1 — Core Backend

* **UC1: Project Setup**

  * Created Spring Boot project
  * Defined package structure (controller, service, repository, dto, etc.)

* **UC2: Database Configuration**

  * Connected MySQL using `application.yml`
  * Enabled Hibernate auto table creation

* **UC3: User Persistence**

  * Created User entity
  * Implemented UserRepository (JPA)

* **UC4: User Registration**

  * DTO validation using `@Valid`
  * Global exception handling implemented

* **UC5: Authentication**

  * Password encrypted using BCrypt
  * JWT token generated on login

* **UC6: JWT Validation**

  * Implemented JWT filter
  * Secured APIs using Spring Security

* **UC7: Note Entity**

  * Created Note entity with flags:

    * isPinned
    * isArchived
    * isTrashed

* **UC8: Create Note**

  * POST API to create note
  * User ID extracted from JWT

* **UC9: Fetch Notes**

  * GET API to fetch user-specific notes
  * Prevented unauthorized access

* **UC10: Toggle Features**

  * Pin / Archive / Trash functionality using PUT APIs

---

### 🔹 Phase 2 — Advanced Backend

* **UC11: AOP Logging**

  * Implemented logging using Aspect-Oriented Programming
  * Tracked method execution time

* **UC12: RabbitMQ**

  * Implemented async messaging (Producer–Consumer)
  * Triggered events on note creation

* **UC13: Redis Caching**

  * Stored JWT tokens with TTL
  * Improved authentication performance

* **UC14: Spring Cache**

  * Cached notes API responses
  * Reduced DB calls
  * Implemented cache eviction

* **UC15: JMS (ActiveMQ)**

  * Implemented queue-based messaging
  * Used `JmsTemplate` and `@JmsListener`

* **UC16: Spring Batch (Excel Upload)**

  * Uploaded Excel file
  * Parsed using Apache POI
  * Bulk inserted notes into database

---

## 📦 API Endpoints

### 🔹 User APIs

* POST `/api/users/register`
* POST `/api/users/login`

### 🔹 Note APIs

* POST `/api/notes`
* GET `/api/notes`
* PUT `/api/notes/{id}/pin`
* PUT `/api/notes/{id}/archive`
* PUT `/api/notes/{id}/trash`

### 🔹 Batch API

* POST `/api/notes/upload` (Excel Upload)

---

## 🧪 How to Run

### 1. Clone Repository

```bash
git clone https://github.com/kaviyasp/fundoo-notes.git
cd fundoo-notes
```

---

### 2. Configure MySQL

Update `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/fundoo_notes
    username: root
    password: your_password
```

---

### 3. Run Required Services (Docker)

```bash
docker run -d --name redis -p 6379:6379 redis
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
docker run -d --name activemq -p 61616:61616 -p 8161:8161 rmohr/activemq
```

---

### 4. Run Application

```bash
mvn spring-boot:run
```

---

## 📊 Excel Upload Format

| title  | content |
| ------ | ------- |
| Note 1 | Hello   |
| Note 2 | World   |

---

## 🔥 Key Highlights

* Secure backend using JWT authentication
* Redis caching for performance optimization
* Async messaging using RabbitMQ & JMS
* Efficient data handling using Spring Batch
* Clean layered architecture

---

## 📌 Future Enhancements

* Swagger API Documentation
* Microservices Architecture
* Cloud Deployment (AWS)
* Frontend Integration

---
