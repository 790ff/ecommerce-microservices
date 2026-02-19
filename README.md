# E-Commerce Microservices System

A microservices-based e-commerce backend built using Spring Boot. The system is split into independent services, each responsible for a specific domain. Services communicate through REST APIs and can be deployed and scaled independently.

---

## Architecture Overview

This system follows a microservices architecture with three core services:

- Product Service — manages product catalog  
- Order Service — manages customer orders  
- User Service — manages user accounts  

Each service:

- Runs independently  
- Has its own database  
- Exposes REST endpoints  
- Communicates via HTTP (REST)

Order Service validates product existence by calling Product Service before creating an order.

---

## Services

| Service | Port | Responsibility |
|--------|------|----------------|
| product-service | 8081 | Product catalog management |
| order-service | 8082 | Order creation and management |
| user-service | 8083 | User account management |

---

## Tech Stack

- Java 21  
- Spring Boot  
- Spring Data JPA  
- H2 In-Memory Database  
- REST APIs  
- Maven or Gradle  

---

## Service Communication Flow

Example: Creating an Order

1. Client sends request to Order Service  
2. Order Service calls Product Service  
3. Product Service confirms product exists  
4. Order Service creates and stores order  
5. Order Service returns response  

---

## API Endpoints

### Product Service — Port 8081

| Method | Endpoint | Description |
|-------|----------|-------------|
| GET | /api/products | Get all products |
| POST | /api/products | Create new product |

Example:

POST /api/products

{
  "name": "Laptop",
  "price": 1200
}

---

### Order Service — Port 8082

| Method | Endpoint | Description |
|-------|----------|-------------|
| GET | /api/orders | Get all orders |
| POST | /api/orders | Create new order |

Example:

POST /api/orders

{
  "productId": 1,
  "quantity": 2
}

---

### User Service — Port 8083

| Method | Endpoint | Description |
|-------|----------|-------------|
| GET | /api/users | Get all users |
| POST | /api/users | Create new user |

Example:

POST /api/users

{
  "name": "Thamer",
  "email": "thamer@example.com"
}

---

## How to Run

Run each service separately:

cd product-service  
./mvnw spring-boot:run  

cd order-service  
./mvnw spring-boot:run  

cd user-service  
./mvnw spring-boot:run  

Each service will start on its configured port.

---

## Project Structure

ecommerce-microservices/  
├── product-service/  
├── order-service/  
└── user-service/  

---

## Database

Each service uses its own H2 in-memory database.

Access H2 console:

http://localhost:8081/h2-console  
http://localhost:8082/h2-console  
http://localhost:8083/h2-console  

---

## Future Improvements

- Add API Gateway  
- Add Service Discovery (Eureka)  
- Use PostgreSQL instead of H2  
- Add authentication (JWT)  
- Use Docker  
- Add centralized config server  

---

## Purpose

This project demonstrates:

- Microservices architecture  
- Service-to-service communication  
- REST API design  
- Clean service separation  
- Backend system design fundamentals

