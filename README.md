# Java Backend Development Repository

This repository represents my Java backend development journey, where I have built multiple projects using Core Java, File Handling, and JDBC with MySQL. Each project is independently structured and focuses on strengthening backend fundamentals and practical implementation skills. This repository will continue to grow as I progress into advanced backend development including Spring Boot, REST APIs, authentication systems, and full-stack backend applications.

Repository Structure:

Backend/
├── UserManagementBackend/
├── ProductManagementBackend/
├── JDBC-CRUD/

Each folder is an independent Java backend project containing its own source code, data files, and execution logic.

Projects Overview:

UserManagementBackend is a File Handling based CRUD application for managing users. It supports operations such as adding users, viewing users, searching users, updating user details, deleting users, and a basic login simulation using local file storage.

ProductManagementBackend is a File Handling based CRUD application for managing product data. It implements full CRUD functionality using Java file input and output streams without any database dependency.

JDBC-CRUD is a MySQL integrated Java application using JDBC for performing database operations such as inserting records, viewing records, and deleting records from a product table.

Tech Stack:

Java (Core Java, Object-Oriented Programming)
File Handling (BufferedReader, BufferedWriter, FileReader, FileWriter)
JDBC (Java Database Connectivity)
MySQL
SQL

How to Run Projects:

All projects are independent and can be executed separately.

For File Handling Projects (UserManagementBackend, ProductManagementBackend):

Navigate to the project folder and open terminal inside src directory. Compile all Java files using:

javac Main.java model/*.java service/*.java

After successful compilation, run the program using:

java Main

For JDBC Project (JDBC-CRUD):

First ensure MySQL server is running. Create the required database and table using the following SQL:

CREATE DATABASE java_backend;

USE java_backend;

CREATE TABLE products (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE
);

After setting up the database, add MySQL JDBC driver to your classpath. Compile the project using:

javac -cp .;mysql-connector-j.jar *.java

Run the project using:

java -cp .;mysql-connector-j.jar Main

Key Learning Outcomes:

Object-Oriented Programming in Java
File Handling and data persistence without database
CRUD operations implementation
Understanding of relational databases and SQL
JDBC integration with Java applications
Layered architecture concepts (Model, Service, DAO)
Backend application structuring

Future Improvements:

This repository will be continuously improved with advanced backend development topics such as Spring Boot REST APIs, authentication and authorization systems using JWT, RESTful backend architecture, exception handling and validation frameworks, API testing using Postman, integration with frontend applications, and deployment of backend services.

Project Goals:

The primary goal of this repository is to build strong backend development fundamentals, gain practical experience in Java-based backend systems, prepare for backend developer internships, and transition towards industry-level Spring Boot development.

Author:

Samarth Varshney