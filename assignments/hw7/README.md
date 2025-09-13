# Homework 7: AVL Tree Implementation for Stock Data Management

## Overview
This assignment implements a self-balancing AVL (Adelson-Velsky and Landis) Tree to efficiently manage stock market data. The system provides optimal performance for insertion, deletion, and search operations while maintaining tree balance through automatic rotations.

## Features
- **AVL Tree Implementation**: Self-balancing binary search tree with guaranteed O(log n) operations
- **Stock Data Management**: Store and manage stock information (symbol, price, volume, market cap)
- **Tree Operations**: Insert, delete, search, and traversal operations
- **Balance Maintenance**: Automatic left and right rotations to maintain AVL property
- **GUI Visualization**: Optional graphical visualization of the tree structure
- **File Processing**: Read stock operations from input files
- **Performance Analysis**: Built-in performance testing capabilities

## Key Components

### AVL Tree Features
- **Height Balancing**: Maintains height difference ≤ 1 between subtrees
- **Automatic Rotations**: Single and double rotations for rebalancing
- **Efficient Operations**: O(log n) insertion, deletion, and search
- **In-order Traversal**: Sorted output of stock data

### Stock Data Structure
- **Symbol**: Unique stock identifier (primary key)
- **Price**: Current stock price
- **Volume**: Trading volume
- **Market Cap**: Market capitalization value

## Class Structure
- `AVLTree.java` - Main AVL tree implementation with Node inner class
- `Stock.java` - Stock data model with all required attributes
- `StockDataManager.java` - High-level manager for stock operations
- `Main.java` - Command-line interface for file processing and operations
- `GUIVisualization.java` - Optional GUI for tree visualization

## AVL Tree Operations

### Core Operations
1. **Insert**: Add new stock maintaining AVL property
2. **Delete**: Remove stock and rebalance tree
3. **Search**: Find stock by symbol in O(log n) time
4. **Update**: Modify existing stock information
5. **Traverse**: In-order traversal for sorted output

### Balancing Operations
- **Left Rotation**: Fix right-heavy imbalance
- **Right Rotation**: Fix left-heavy imbalance
- **Left-Right Rotation**: Fix left-right imbalance
- **Right-Left Rotation**: Fix right-left imbalance

## Input File Format
The system processes commands from `input.txt`:
```
ADD SYMBOL PRICE VOLUME MARKETCAP
DELETE SYMBOL
SEARCH SYMBOL
UPDATE SYMBOL PRICE VOLUME MARKETCAP
```

## How to Run
1. Compile all Java files: `make compile` or `javac *.java`
2. Run with input file: `make run` or `java Main input.txt`
3. For GUI visualization: `java GUIVisualization`
4. For performance testing: `python test.py`

## Performance Characteristics

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Insert | O(log n) | O(1) |
| Delete | O(log n) | O(1) |
| Search | O(log n) | O(1) |
| Traversal | O(n) | O(log n) |

## AVL Tree Properties
- **Balance Factor**: Height difference between left and right subtrees ≤ 1
- **Height**: O(log n) guaranteed maximum height
- **Rotations**: Constant time rebalancing operations
- **Self-Balancing**: Automatic maintenance of optimal structure

## Example Usage
```java
AVLTree stockTree = new AVLTree();
Stock apple = new Stock("AAPL", 150.0, 1000000, 2500000000L);
stockTree.insert(apple);
Stock found = stockTree.search("AAPL");
stockTree.delete("AAPL");
```

## Learning Objectives
- Understanding self-balancing binary search trees
- Implementing tree rotations for balance maintenance
- Managing complex data structures with multiple attributes
- File I/O processing and command parsing
- Performance analysis of tree operations
- GUI programming for data visualization

## Advanced Features
- **Performance Testing**: Automated testing with large datasets
- **Visualization**: Graphical representation of tree structure
- **Batch Processing**: Handle multiple operations from input files
- **Error Handling**: Robust handling of invalid operations

## Data Structure Benefits
- **Guaranteed Performance**: O(log n) for all major operations
- **Automatic Balancing**: No manual intervention required
- **Memory Efficient**: Minimal overhead compared to hash tables
- **Ordered Traversal**: Natural sorting of stock symbols

## Files
- Source code implementations (*.java)
- Input data file (`input.txt`)
- Performance testing script (`test.py`)
- Documentation (`doc/` directory)
- Assignment report (`rapor hw7.pdf`)
- Makefile for build automation
- Student submission archive (contains personal information)

## Tree Visualization
The GUI component provides visual representation of:
- Tree structure and node relationships
- Balance factors and heights
- Rotation operations in real-time
- Stock data at each node