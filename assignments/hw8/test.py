import networkx as nx
import matplotlib as plt
plt.use('TkAgg')

import heapq

def dijkstra(graph, start):
    n = graph.number_of_nodes()
    dist = {node: float('inf') for node in graph.nodes()}
    dist[start] = 0
    visited = {node: False for node in graph.nodes()}
    pq = [(0, start)]  # Priority queue (min-heap)
    predecessor = {node: None for node in graph.nodes()}

    while pq:
        current_dist, u = heapq.heappop(pq)
        if visited[u]:
            continue
        visited[u] = True

        for v in graph.neighbors(u):
            if not visited[v]:
                new_dist = current_dist + graph[u][v]['weight']
                if new_dist < dist[v]:
                    dist[v] = new_dist
                    predecessor[v] = u
                    heapq.heappush(pq, (new_dist, v))

    return dist, predecessor

def visualize_dijkstra(graph, start):
    pos = nx.spring_layout(graph)
    dist, predecessor = dijkstra(graph, start)

    plt.figure(figsize=(10, 8))

    # Draw the graph
    nx.draw(graph, pos, with_labels=True, node_color='lightblue', node_size=500, font_size=10, font_weight='bold', edge_color='gray')

    # Draw the shortest path tree
    for node in graph.nodes():
        if predecessor[node] is not None:
            nx.draw_networkx_edges(graph, pos, edgelist=[(predecessor[node], node)], width=2.5, alpha=0.6, edge_color='r')
    
    # Draw the node distances
    dist_labels = {node: f"{dist[node]}" for node in dist}
    nx.draw_networkx_labels(graph, pos, labels=dist_labels, font_size=10, font_color='black')

    plt.title("Visualization of Dijkstra's Algorithm")
    plt.show()

# Force the use of TkAgg backend
import matplotlib
matplotlib.use('TkAgg')

# Create a graph
G = nx.Graph()
edges = [
    (0, 1, 4), (0, 2, 1), (2, 1, 2), (1, 3, 1), (2, 3, 5), (3, 4, 3)
]
G.add_weighted_edges_from(edges)

# Visualize Dijkstra's algorithm
visualize_dijkstra(G, start=0)
