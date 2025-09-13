# Homework 8: Social Network Graph Analysis

## Overview
This assignment implements a comprehensive social network analysis system using graph data structures. The system models people as nodes and friendships as edges, providing various graph algorithms for social network analysis including shortest paths, friend suggestions, and community detection.

## Features
- **Graph-Based Social Network**: People as vertices, friendships as edges
- **Dynamic Network Management**: Add/remove people and friendships
- **Shortest Path Finding**: Find shortest connection between any two people
- **Friend Recommendations**: Suggest friends based on mutual connections and shared interests
- **Community Detection**: Identify connected components (clusters) in the network
- **Interactive Menu System**: User-friendly command-line interface
- **Automated Testing**: Performance testing with large datasets

## Key Components

### Graph Structure
- **Adjacency List Representation**: Efficient storage using HashMap
- **Bidirectional Edges**: Friendships are mutual connections
- **Person Attributes**: Name, age, hobbies, and timestamps
- **Dynamic Operations**: Real-time network modifications

### Core Algorithms
1. **Breadth-First Search (BFS)**: For shortest path finding
2. **Depth-First Search (DFS)**: For connected component analysis
3. **Friend Recommendation Algorithm**: Based on mutual friends and hobby similarity
4. **Graph Traversal**: Complete network exploration

## Class Structure
- `SocialNetworkGraph.java` - Main graph implementation with all network operations
- `Person.java` - Person data model with attributes and utility methods
- `Main.java` - Interactive command-line interface for network management
- `Test.java` - Automated testing system with random data generation

## Social Network Operations

### Person Management
- **Add Person**: Add new person with name, age, and hobbies
- **Remove Person**: Remove person and all associated friendships
- **Find Person**: Search for person by name

### Friendship Management
- **Add Friendship**: Create bidirectional friendship between two people
- **Remove Friendship**: Remove friendship connection
- **List Friends**: Display all friends of a person

### Network Analysis
- **Shortest Path**: Find shortest chain of friendships between two people
- **Friend Suggestions**: Recommend friends based on:
  - Mutual friends (friends of friends)
  - Shared hobbies and interests
  - Age similarity
- **Cluster Analysis**: Count connected components in the network

## Menu Options
1. Add a person
2. Remove a person  
3. Add a friendship
4. Remove a friendship
5. Find shortest path between two people
6. Suggest friends for a person
7. Count clusters
8. Exit

## Algorithm Details

### Shortest Path (BFS)
- Uses breadth-first search to find minimum friendship hops
- Time Complexity: O(V + E) where V = people, E = friendships
- Returns path and distance between any two people

### Friend Suggestion Algorithm
Considers multiple factors:
- **Mutual Friends**: People with common friends get higher priority
- **Hobby Similarity**: Shared interests increase recommendation score
- **Age Proximity**: Similar age groups are preferred
- **Network Distance**: Closer people in the graph are preferred

### Cluster Counting (DFS)
- Uses depth-first search to identify connected components
- Each component represents a social cluster
- Helps understand network fragmentation

## Data Structures Used
- **HashMap**: For O(1) person lookup by name
- **ArrayList**: For adjacency lists and friend storage
- **Queue**: For BFS implementation
- **Stack**: For DFS implementation (implicit via recursion)

## How to Run
1. Compile all Java files: `make compile` or `javac *.java`
2. Run interactive mode: `make run` or `java Main`
3. Run automated tests: `java Test`
4. Performance testing: `python test.py`

## Example Usage
```
===== Social Network Analysis Menu =====
1. Add a person
2. Remove a person
3. Add a friendship
4. Remove a friendship
5. Find the shortest path between two people
6. Suggest friends for a person
7. Count clusters
8. Exit
```

## Performance Characteristics

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Add Person | O(1) | O(1) |
| Add Friendship | O(1) | O(1) |
| Remove Person | O(V + E) | O(1) |
| Shortest Path | O(V + E) | O(V) |
| Friend Suggestions | O(V + E) | O(V) |
| Count Clusters | O(V + E) | O(V) |

## Learning Objectives
- Understanding graph data structures and representations
- Implementing graph traversal algorithms (BFS, DFS)
- Applying graph algorithms to real-world problems
- Social network analysis concepts
- Algorithm design for recommendation systems
- Performance analysis of graph operations

## Advanced Features
- **Weighted Recommendations**: Scoring system for friend suggestions
- **Multi-criteria Analysis**: Combining multiple factors for recommendations
- **Large Dataset Handling**: Scalable design for thousands of users
- **Real-time Updates**: Dynamic network modifications

## Graph Properties Analyzed
- **Connectivity**: How well-connected the network is
- **Clustering**: Formation of social groups
- **Path Lengths**: Average degrees of separation
- **Node Centrality**: Important people in the network

## Files
- Source code implementations (*.java)
- Performance testing script (`test.py`)
- Documentation (`doc/` directory)
- Assignment report (PDF)
- Makefile for build automation
- Student submission archive (contains personal information)

## Social Network Insights
The system can reveal:
- Most connected individuals
- Isolated groups or cliques
- Bridge connections between communities
- Potential friend recommendations
- Network growth patterns