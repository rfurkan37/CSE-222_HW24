import java.util.*;

/**
 * A class to represent a social network graph.
 * The graph is represented by a map of people and their friendships.
 */
public class SocialNetworkGraph {
    /**
     * Map of people in the network.
     */
    Map<String, Person> people;

    /**
     * Map of friendships by person.
     */
    Map<Person, List<Person>> friendships; // Map of friendships by person

    /**
     * Constructor for the SocialNetworkGraph class.
     * Initializes the social network graph with an empty name, age, and list of
     * hobbies.
     */
    public SocialNetworkGraph() {
        this.people = new HashMap<>();
        this.friendships = new HashMap<>();
    }

    /**
     * Method to add a person to the network
     *
     * @param name    Name of the person to add
     * @param age     Age of the person to add
     * @param hobbies List of hobbies of the person
     */
    public void addPerson(String name, int age, List<String> hobbies) {
        Person person = new Person(name, age, hobbies);
        people.put(name, person);
        friendships.put(person, new ArrayList<>());
        System.out.println("Person added: " + person);
    }

    /**
     * Method to remove a person from the network
     *
     * @param name Name of the person to remove
     */
    public void removePerson(String name) {
        Person person = people.get(name);
        if (person != null) {
            people.remove(name);
            friendships.remove(person);
            for (List<Person> friends : friendships.values()) {
                friends.remove(person);
            }
            System.out.println("Person removed: " + person);
        } else {
            System.out.println("Person not found in the network.");
        }
    }

    /**
     * Method to add a friendship between two people
     *
     * @param name1 Name of the first person
     * @param name2 Name of the second person
     */
    public void addFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        if (person1 != null && person2 != null) {
            friendships.get(person1).add(person2);
            friendships.get(person2).add(person1);
            System.out.println("Friendship added between " + person1.name + " and " + person2.name);
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }

    /**
     * Method to remove a friendship between two people
     *
     * @param name1 Name of the first person
     * @param name2 Name of the second person
     */
    public void removeFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        if (person1 != null && person2 != null) {
            friendships.get(person1).remove(person2);
            friendships.get(person2).remove(person1);
            System.out.println("Friendship removed between " + person1.name + " and " + person2.name);
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }

    /**
     * Method to find the shortest path between two people in the network
     *
     * @param startName Name of the starting person
     * @param endName   Name of the ending person
     */
    public void findShortestPath(String startName, String endName) {
        Person start = people.get(startName);
        Person end = people.get(endName);
        if (start == null || end == null) {
            System.out.println("One or both persons not found in the network.");
            return;
        }

        Map<Person, Person> prev = new HashMap<>(); // Map to store the previous person in the path
        Queue<Person> queue = new LinkedList<>(); // Queue for BFS
        Set<Person> visited = new HashSet<>(); // Set to store visited persons
        queue.add(start); // Add the starting person to the queue
        visited.add(start); // Mark the starting person as visited

        while (!queue.isEmpty()) { // While the queue is not empty
            Person current = queue.poll(); // Dequeue the current person
            if (current == end) { // If the current person is the ending person
                printPath(end, prev); // Print the path
                return;
            }

            for (Person neighbor : friendships.get(current)) { // For each friend of the current person
                if (!visited.contains(neighbor)) { // If the friend has not been visited
                    queue.add(neighbor); // Add the friend to the queue
                    visited.add(neighbor); // Mark the friend as visited
                    prev.put(neighbor, current); // Set the current person as the previous person for the friend
                }
            }
        }

        System.out.println("No path found between " + startName + " and " + endName); // If no path is found
    }

    /**
     * Helper method to print the shortest path between two people
     *
     * @param end  The ending person
     * @param prev Map of previous persons in the path
     */
    private void printPath(Person end, Map<Person, Person> prev) {
        List<Person> path = new ArrayList<>(); // List to store the path
        for (Person at = end; at != null; at = prev.get(at)) { // Traverse the path from the end to the start
            path.add(at);
        }
        Collections.reverse(path); // Reverse the path to get the correct order

        StringBuilder pathString = new StringBuilder(); // String to store the path
        for (int i = 0; i < path.size(); i++) { // For each person in the path
            pathString.append(path.get(i).getName()); // Add the person's name to the string
            if (i < path.size() - 1) { // If it's not the last person
                pathString.append("->"); // Add an arrow
            }
        }
        System.out.println("Shortest path: " + pathString); // Print the path
    }

    /**
     * Method to count the number of clusters in the network
     */
    public void countClusters() {
        Set<Person> visited = new HashSet<>(); // Set to store visited persons
        int count = 0;

        System.out.println("Counting clusters in the social network...");

        for (Person person : people.values()) { // For each person in the network
            if (!visited.contains(person)) { // If the person has not been visited
                List<Person> cluster = new ArrayList<>(); // List to store the cluster
                bfs(person, visited, cluster); // Perform BFS to find the cluster
                count++; // Increment the cluster count
                System.out.println("Cluster " + count + ":");
                for (Person p : cluster) {
                    System.out.println(p.getName());
                }
                System.out.println(); // Print an empty line for separation between clusters
            }
        }

        System.out.println("Total clusters: " + count); // Print the total number of clusters
    }

    /**
     * Method to suggest friends for a person based on mutual friends and common
     * hobbies
     *
     * @param name           Name of the person
     * @param maxSuggestions Maximum number of suggestions to display
     */
    public void suggestFriends(String name, int maxSuggestions) {
        Person person = people.get(name); // Get the person from the network
        if (person == null) { // If the person is not found
            System.out.println("Person not found in the network."); // Print an error message
            return;
        }

        Map<Person, Double> scores = new HashMap<>(); // Map to store the scores for potential friends
        for (Person potentialFriend : people.values()) { // For each person in the network
            if (!friendships.get(person).contains(potentialFriend) && !potentialFriend.equals(person)) { // If the
                                                                                                         // person is
                                                                                                         // not already
                                                                                                         // a friend
                double score = 0.0; // Initialize the score
                List<Person> mutualFriends = new ArrayList<>(friendships.get(person)); // List to store mutual friends
                mutualFriends.retainAll(friendships.get(potentialFriend)); // Find the mutual friends
                score += mutualFriends.size(); // Add the number of mutual friends to the score

                List<String> commonHobbies = new ArrayList<>(person.getHobbies()); // List to store common hobbies
                commonHobbies.retainAll(potentialFriend.getHobbies()); // Find the common hobbies
                score += commonHobbies.size() * 0.5; // Add half the number of common hobbies to the score

                scores.put(potentialFriend, score); // Store the score for the potential friend
            }
        }

        List<Map.Entry<Person, Double>> sortedScores = new ArrayList<>(scores.entrySet()); // List to store sorted
                                                                                           // scores
        sortedScores.sort(Map.Entry.<Person, Double>comparingByValue().reversed()); // Sort the scores in descending
                                                                                    // order

        System.out.println("Suggestions for " + person.getName() + ":"); // Print the suggestions
        for (int i = 0; i < Math.min(maxSuggestions, sortedScores.size()); i++) { // For each suggestion
            Map.Entry<Person, Double> entry = sortedScores.get(i); // Get the suggestion
            System.out.println(entry.getKey().getName() + " with score " + entry.getValue()); // Print the suggestion
        }
    }

    /**
     * Helper method to perform BFS to find a cluster of friends
     *
     * @param start   Person to start the BFS from
     * @param visited Set of visited persons
     * @param cluster List to store the cluster
     */
    private void bfs(Person start, Set<Person> visited, List<Person> cluster) {
        Queue<Person> queue = new LinkedList<>(); // Queue for BFS
        queue.add(start); // Add the starting person to the queue
        visited.add(start); // Mark the starting person as visited

        while (!queue.isEmpty()) { // While the queue is not empty
            Person current = queue.poll(); // Dequeue the current person
            cluster.add(current); // Add the current person to the cluster

            for (Person neighbor : friendships.get(current)) { // For each friend of the current person
                if (!visited.contains(neighbor)) { // If the friend has not been visited
                    queue.add(neighbor); // Add the friend to the queue
                    visited.add(neighbor); // Mark the friend as visited
                }
            }
        }
    }

    /**
     * Method to get a person from the network by name
     * 
     * @param name Name of the person
     * @return Person object with the given name
     */
    public Person getPerson(String name) {
        return people.get(name);
    }
}
