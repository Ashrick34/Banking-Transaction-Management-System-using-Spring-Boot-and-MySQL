#  Banking Transaction Management System

A backend banking application built using **Spring Boot** and **MySQL** that supports core banking operations such as account creation, deposits, withdrawals, fund transfers, and transaction tracking.

---

##  Features

  - Customer Management  
  - Create new customers  
  - View all customers  

  - Account Management  
  - Create bank accounts  
  - Auto-generate account numbers  

  - Transactions  
  - Deposit money  
  - Withdraw money  
  - Transfer funds between accounts  

  - Transaction History  
  - Track all transactions  
  - View transactions by account  
 

---

## Tech Stack

- Backend: Spring Boot (Java 21)  
- Database: MySQL  
- ORM: Spring Data JPA (Hibernate)  
- Build Tool: Maven  
- API Testing: Postman  
- Documentation: Swagger (OpenAPI)  

---

## Project Structure


- controller → REST Controllers (API Layer)  
- service → Business Logic  
- repository → Database Access Layer  
- entity → JPA Entities  
- BankingSystemApplication.java  

---

## How to Run the Project

1. Clone the repository:
git clone https://github.com/Ashrick34/Banking-Transaction-Management-System-using-Spring-Boot-and-MySQL.git  

2. Open in IDE (Eclipse / IntelliJ)

3. Configure MySQL in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/banking_db  
spring.datasource.username=root  
spring.datasource.password=your_password  

spring.jpa.hibernate.ddl-auto=update  

4. Run the application:
mvn spring-boot:run  

5. Access APIs via Postman or browser  

---

## API Documentation (Swagger)

After running the application, open:  
http://localhost:8080/swagger-ui/index.html  

---

## Key Concepts Used

- Spring Boot REST APIs  
- Layered Architecture (Controller → Service → Repository)  
- JPA & Hibernate ORM  
- Transaction Management using `@Transactional`  
- Derived Query Methods in Spring Data JPA  
- Exception Handling  

---

## Author

Ashrick Joshua  

--- 
