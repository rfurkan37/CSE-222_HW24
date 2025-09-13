# Homework 6: Sorting Algorithms Implementation and Analysis

## Overview
This assignment implements and compares four fundamental sorting algorithms: Selection Sort, Bubble Sort, Quick Sort, and Merge Sort. Each algorithm is analyzed for performance by counting comparisons and swaps, providing insights into their computational complexity.

## Features
- **Multiple Sorting Algorithms**: Implementation of four different sorting techniques
- **Performance Metrics**: Automatic counting of comparisons and swaps
- **Comparative Analysis**: Side-by-side performance comparison
- **Inheritance Structure**: Common base class for all sorting algorithms
- **Comprehensive Testing**: Unified testing framework for all algorithms

## Implemented Algorithms

### 1. Selection Sort
- **Time Complexity**: O(n²) in all cases
- **Space Complexity**: O(1)
- **Strategy**: Find minimum element and place it at the beginning
- **Characteristics**: In-place, unstable, simple implementation

### 2. Bubble Sort
- **Time Complexity**: O(n²) average and worst case, O(n) best case
- **Space Complexity**: O(1)
- **Strategy**: Repeatedly swap adjacent elements if they are in wrong order
- **Characteristics**: In-place, stable, simple but inefficient

### 3. Quick Sort
- **Time Complexity**: O(n log n) average case, O(n²) worst case
- **Space Complexity**: O(log n) due to recursion
- **Strategy**: Divide-and-conquer using pivot partitioning
- **Characteristics**: In-place, unstable, generally efficient

### 4. Merge Sort
- **Time Complexity**: O(n log n) in all cases
- **Space Complexity**: O(n) for temporary arrays
- **Strategy**: Divide-and-conquer with merging of sorted subarrays
- **Characteristics**: Stable, consistent performance, requires extra memory

## Class Structure
- `SortAlgorithm.java` - Abstract base class with common functionality
- `SelectionSort.java` - Selection sort implementation
- `BubbleSort.java` - Bubble sort implementation
- `QuickSort.java` - Quick sort implementation
- `MergeSort.java` - Merge sort implementation
- `tester.java` - Test harness for comparing all algorithms

## Key Features of Base Class
- **Array Management**: Handles array cloning to preserve original data
- **Performance Counting**: Tracks comparisons and swaps automatically
- **Unified Interface**: Common methods for all sorting implementations
- **Result Display**: Standardized output format for analysis

## Performance Metrics
Each algorithm tracks:
- **Comparison Counter**: Number of element comparisons performed
- **Swap Counter**: Number of element swaps/moves performed
- **Final Sorted Array**: The resulting sorted array

## How to Run
1. Compile all Java files: `make compile` or `javac *.java`
2. Run the tester: `make test` or `java tester`
3. Observe comparative performance metrics for all algorithms

## Example Output
```
Initial Array: 4 2 6 5 1 8 7 3

Selection Sort:
Comparison Counter: 28    Swap Counter: 7    Sorted Array: 1 2 3 4 5 6 7 8

Bubble Sort:
Comparison Counter: 28    Swap Counter: 14   Sorted Array: 1 2 3 4 5 6 7 8

Quick Sort:
Comparison Counter: 19    Swap Counter: 8    Sorted Array: 1 2 3 4 5 6 7 8

Merge Sort:
Comparison Counter: 13    Swap Counter: 24   Sorted Array: 1 2 3 4 5 6 7 8
```

## Algorithm Comparison

| Algorithm | Time Complexity | Space Complexity | Stable | In-Place |
|-----------|----------------|------------------|---------|----------|
| Selection Sort | O(n²) | O(1) | No | Yes |
| Bubble Sort | O(n²) | O(1) | Yes | Yes |
| Quick Sort | O(n log n) avg | O(log n) | No | Yes |
| Merge Sort | O(n log n) | O(n) | Yes | No |

## Learning Objectives
- Understanding different sorting algorithm paradigms
- Analyzing algorithm performance through empirical measurement
- Comparing time and space complexity trade-offs
- Implementing inheritance and polymorphism
- Performance analysis and algorithm selection criteria

## Design Patterns Used
- **Template Method**: Base class defines common structure
- **Strategy Pattern**: Different sorting strategies with common interface
- **Factory Method**: Each class creates its own sorting implementation

## Documentation
- Performance report available in PDF format
- Assignment requirements and analysis template provided
- Makefile for easy compilation and testing

## Files
- Source code implementations (*.java)
- Performance analysis report (PDF)
- Report template (DOCX)
- Makefile for build automation
- Student submission archive (contains personal information)