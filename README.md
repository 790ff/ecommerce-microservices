# E-Commerce Microservices





A microservices-based e-commerce system built with Spring Boot.



\## Services



| Service | Port | Description |

|---------|------|-------------|

| product-service | 8081 | Manages products |

| order-service | 8082 | Manages orders |

| user-service | 8083 | Manages users |



\## Architecture



Three independent Spring Boot services communicating via REST APIs.

Order service validates product existence by calling product-service before creating an order.



\## Tech Stack



\- Java 21

\- Spring Boot 4

\- Spring Data JPA

\- H2 In-Memory Database

\- REST APIs



\## API Endpoints



\### Product Service (port 8081)

\- GET /api/products

\- POST /api/products



\### Order Service (port 8082)

\- GET /api/orders

\- POST /api/orders



\### User Service (port 8083)

\- GET /api/users

\- POST /api/users

