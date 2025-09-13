# Homework 3: Electronics Inventory Management System

## Overview
This assignment implements a comprehensive electronics inventory management system using object-oriented programming principles and interface design in Java. The system manages various types of electronic devices with full CRUD operations.

## Features
- **Device Management**: Add, remove, update, and search electronic devices
- **Inventory Operations**: List all devices, sort by various criteria, calculate inventory value
- **Device Categories**: Support for laptops, smartphones, TVs, headphones, and smartwatches
- **Restocking System**: Automatic restocking of low-quantity items
- **Data Export**: Export inventory reports to text files
- **Command-Line Interface**: User-friendly menu-driven interface

## Device Types
- **Laptop**: Portable computers with specific RAM and processor specifications
- **Smartphone**: Mobile devices with storage capacity and camera resolution
- **TV**: Television sets with screen size and resolution details
- **Headphones**: Audio devices with type and noise cancellation features
- **Smartwatch**: Wearable devices with heart rate and GPS features

## Class Structure
- `Device.java` - Interface defining common device properties
- `Laptop.java` - Laptop device implementation
- `Smartphone.java` - Smartphone device implementation  
- `TV.java` - Television device implementation
- `Headphones.java` - Headphone device implementation
- `Smartwatch.java` - Smartwatch device implementation
- `Inventory.java` - Main inventory management class with ArrayList backend
- `App.java` - Command-line interface and user interaction

## Key Operations
1. **Add Device**: Add new devices with category-specific attributes
2. **Remove Device**: Remove devices by name
3. **Update Device**: Modify device details (price, quantity, etc.)
4. **List Devices**: Display all devices or filter by category
5. **Find Device**: Search for specific devices by name
6. **Sort Inventory**: Sort by price, quantity, or name
7. **Restock Devices**: Automatically restock low-quantity items
8. **Calculate Total Value**: Compute total inventory worth
9. **Export Report**: Generate inventory reports

## How to Run
1. Compile all Java files: `make compile` or `javac *.java`
2. Run the application: `make run` or `java App`
3. Follow the interactive menu to manage inventory

## Data Structures Used
- **ArrayList**: For storing and managing device collections
- **Interface Implementation**: For polymorphic device handling
- **Scanner**: For user input processing

## Time Complexity
- Add Device: O(1)
- Remove Device: O(n)
- Find Device: O(n)
- Sort Operations: O(n log n)
- List Operations: O(n)

## Learning Objectives
- Interface design and implementation
- Polymorphism and inheritance
- ArrayList operations and management
- User interface design
- File I/O operations
- Object-oriented design patterns

## Documentation
- Full JavaDoc documentation available in `javadoc/` directory
- Class diagram provided as `classdiagram.png`
- Assignment requirements in `CSE222_HW3.pdf`