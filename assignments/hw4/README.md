# Homework 4: File System Implementation

## Overview
This assignment implements a hierarchical file system management program using object-oriented programming principles in Java. The system simulates basic file system operations with a tree-like directory structure.

## Features
- **Directory Navigation**: Change current directory and navigate file system
- **File Operations**: Create, delete, and manage files
- **Directory Operations**: Create, delete, and manage directories  
- **Listing**: Display directory contents with details
- **Path Management**: Support for both absolute and relative paths
- **Timestamps**: Track creation dates for files and directories
- **Interactive Interface**: Menu-driven command-line interface

## Class Structure
- `FileSystemElement.java` - Abstract base class for all file system elements
- `File.java` - Concrete implementation for files with size and content
- `Directory.java` - Concrete implementation for directories with child elements
- `FileSystem.java` - Main file system manager with navigation and operations
- `Main.java` - Command-line interface and user interaction

## Key Operations
1. **Change Directory (cd)**: Navigate to different directories
2. **List Contents (ls)**: Display files and directories in current location
3. **Create File**: Add new files to the current directory
4. **Create Directory**: Add new subdirectories
5. **Delete File**: Remove files from the system
6. **Delete Directory**: Remove directories (with contents)
7. **Display Current Path**: Show current location in file system
8. **Search**: Find files and directories by name

## Data Structures Used
- **Tree Structure**: Hierarchical organization of directories and files
- **ArrayList**: For storing directory contents
- **Composition Pattern**: Directories contain other file system elements
- **Inheritance**: Common functionality through abstract base class

## File System Hierarchy
```
Root Directory (/)
├── Directory1/
│   ├── File1.txt
│   └── Subdirectory/
│       └── File2.txt
└── Directory2/
    └── File3.txt
```

## How to Run
1. Compile all Java files: `make compile` or `javac *.java`
2. Run the program: `make run` or `java Main`
3. Use the interactive menu to navigate and manage the file system

## Menu Options
1. Change directory
2. List directory contents
3. Create file
4. Create directory
5. Delete file
6. Delete directory
7. Display current path
8. Search for file/directory
9. Exit

## Design Patterns Used
- **Abstract Factory**: FileSystemElement as base for different element types
- **Composite Pattern**: Directory can contain both files and other directories
- **Command Pattern**: Menu-driven operations

## Learning Objectives
- Tree data structure implementation
- Abstract classes and inheritance
- File system concepts and operations
- Object-oriented design principles
- User interface design
- Path resolution and navigation

## Documentation
- Full JavaDoc documentation available in `javadoc/` directory
- Assignment requirements in `CSE222 HW4.pdf`

## Time Complexity
- Navigation: O(d) where d is directory depth
- File Creation: O(1)
- Directory Listing: O(n) where n is number of items
- Search: O(n) where n is total number of elements
- Delete Operations: O(n) for recursive directory deletion