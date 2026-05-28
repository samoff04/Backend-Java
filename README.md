# Java Backend Development

## Overview

This repository contains my Java backend learning journey focused on building and practicing backend development concepts using Core Java, File Handling, and JDBC with MySQL. It includes multiple projects developed to strengthen programming fundamentals, problem-solving skills, and backend development understanding. This repository will continue to evolve as I progress into advanced backend technologies such as Spring Boot, REST APIs, authentication systems, and full-stack backend development.

## Clone Repository

git clone https://www.github.com/samoff04/Backend-Java
cd Backend-Java

## Project Structure

Backend-Java/
├── UserManagementBackend/
├── ProductManagementBackend/
├── JDBC-CRUD/

Each folder contains an independent Java backend project.

## Tech Stack

- Java (Core Java, OOP)
- File Handling (I/O Streams)
- JDBC (Java Database Connectivity)
- MySQL
- SQL

## How to Run

### File Handling Projects

cd UserManagementBackend/src
javac Main.java model/*.java service/*.java
java Main

Repeat same steps for ProductManagementBackend.

### JDBC Project

Create database:

CREATE DATABASE java_backend;
USE java_backend;

CREATE TABLE products (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE
);

Add MySQL JDBC driver.

Compile:
javac -cp .;mysql-connector-j.jar *.java

Run:
java -cp .;mysql-connector-j.jar Main

## Future Scope

- Spring Boot REST APIs
- Authentication and Authorization systems
- Advanced backend architecture
- Production-level backend applications

## Author

Samarth Varshney
