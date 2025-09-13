
# Homework 1: Customer Tracking System

## Overview
This assignment implements a customer tracking program using object-oriented programming principles in Java. The system manages customers, operators, and orders with proper error handling and file I/O operations.

## Features
- **Customer Management**: Handle both retail and corporate customers
- **Operator Management**: Track operators and their associations with customers
- **Order Processing**: Process various types of orders (TV, computer, smartphone)
- **File I/O**: Read customer and order data from text files
- **Error Handling**: Robust error handling for both strings and integers
- **Data Validation**: Check for duplicate entries and validate input data

## Class Structure
- `Person.java` - Base class for all persons
- `Customer.java` - Abstract customer class extending Person
- `RetailCustomer.java` - Implementation for retail customers
- `CorporateCustomer.java` - Implementation for corporate customers
- `Operator.java` - Operator class extending Person
- `Order.java` - Order management class
- `App.java` - Main application class with data processing logic

## Input Format
The program reads from `content.txt` with the following format:
- Orders: `order;product;quantity;price;operator_id;customer_id`
- Retail Customers: `retail_customer;name;surname;city;phone;id;operator_id`
- Corporate Customers: `corporate_customer;name;surname;city;phone;id;operator_id;company`
- Operators: `operator;name;surname;city;phone;id;wage`

## How to Run
1. Compile all Java files: `javac *.java`
2. Run the main application: `java App`
3. Ensure `content.txt` is in the same directory

## Learning Objectives
- Object-oriented programming principles
- Inheritance and polymorphism
- File I/O operations in Java
- Error handling and validation
- Array-based data management
