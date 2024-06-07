import java.util.*;

/**
 * Main class for the Social Network Analysis program.
 * This class provides a text-based menu for interacting with the SocialNetworkGraph class.
 */
public class Main {

    /**
     * Constructor for the Main class.
     */
    public Main() {
        // Empty constructor
    }

    /**
     * Main method for the Social Network Analysis program.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        SocialNetworkGraph network = new SocialNetworkGraph(); // Create a new SocialNetworkGraph object
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object to read user input

        while (true) {
            System.out.println("===== Social Network Analysis Menu =====");
            System.out.println("1. Add a person");
            System.out.println("2. Remove a person");
            System.out.println("3. Add a friendship");
            System.out.println("4. Remove a friendship");
            System.out.println("5. Find the shortest path between two people");
            System.out.println("6. Suggest friends for a person");
            System.out.println("7. Count clusters");
            System.out.println("8. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPerson(scanner, network);
                    break;
                case 2:
                    removePerson(scanner, network);
                    break;
                case 3:
                    addFriendship(scanner, network);
                    break;
                case 4:
                    removeFriendship(scanner, network);
                    break;
                case 5:
                    findShortestPath(scanner, network);
                    break;
                case 6:
                    suggestFriends(scanner, network);
                    break;
                case 7:
                    countClusters(network);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
            }

        }


    }


    /**
     * Prompts the user for the name, age, and hobbies of a person, and adds the person to the network.
     *
     * @param scanner Scanner object to read user input
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void addPerson(Scanner scanner, SocialNetworkGraph network) {
        String nameToAdd = promptForString(scanner, "Enter the name of the person: ");
        int age = promptForInt(scanner, "Enter the age of the person: ");
        List<String> hobbies = promptForList(scanner);
        network.addPerson(nameToAdd, age, hobbies);
    }

    /**
     * Prompts the user for the name of a person, and removes the person from the network.
     *
     * @param scanner Scanner object to read user input
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void removePerson(Scanner scanner, SocialNetworkGraph network) {
        String nameToRemove = promptForString(scanner, "Enter the name of the person: ");
        network.removePerson(nameToRemove);
    }

    /**
     * Prompts the user for the names of two people, and adds a friendship between them.
     *
     * @param scanner Scanner object to read user input
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void addFriendship(Scanner scanner, SocialNetworkGraph network) {
        String name1 = promptForString(scanner, "Enter the name of the first person: ");
        String name2 = promptForString(scanner, "Enter the name of the second person: ");
        network.addFriendship(name1, name2);
    }

    /**
     * Prompts the user for the names of two people, and removes a friendship between them.
     *
     * @param scanner Scanner object to read user input
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void removeFriendship(Scanner scanner, SocialNetworkGraph network) {
        String name1 = promptForString(scanner, "Enter the name of the first person: ");
        String name2 = promptForString(scanner, "Enter the name of the second person: ");
        network.removeFriendship(name1, name2);
    }

    /**
     * Prompts the user for the names of two people, and finds the shortest path between them.
     *
     * @param scanner Scanner object to read user input
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void findShortestPath(Scanner scanner, SocialNetworkGraph network) {
        String name1 = promptForString(scanner, "Enter the name of the first person: ");
        String name2 = promptForString(scanner, "Enter the name of the second person: ");
        network.findShortestPath(name1, name2);
    }

    /**
     * Prompts the user for the name of a person and the maximum number of suggestions, and suggests friends for the person.
     *
     * @param scanner Scanner object to read user input
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void suggestFriends(Scanner scanner, SocialNetworkGraph network) {
        String name = promptForString(scanner, "Enter the name of the person: ");
        int maxSuggestions = promptForInt(scanner, "Enter the maximum number of suggestions: ");
        network.suggestFriends(name, maxSuggestions);
    }

    /**
     * Counts the number of clusters in the network.
     *
     * @param network SocialNetworkGraph object representing the social network
     */
    public static void countClusters(SocialNetworkGraph network) {
        System.out.println("Counting clusters...");
        network.countClusters();
    }

    /**
     * Prompts the user for a string input with a given prompt.
     *
     * @param scanner Scanner object to read user input
     * @param prompt  Prompt to display to the user
     * @return String input from the user
     */
    private static String promptForString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Prompts the user for an integer input with a given prompt.
     *
     * @param scanner Scanner object to read user input
     * @param prompt  Prompt to display to the user
     * @return Integer input from the user
     */
    private static int promptForInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        int result = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return result;
    }

    /**
     * Prompts the user for a list of items separated by commas.
     *
     * @param scanner Scanner object to read user input
     * @return List of items entered by the user
     */
    private static List<String> promptForList(Scanner scanner) {
        System.out.print("Enter the hobbies of the person (comma-separated): ");
        String[] items = scanner.nextLine().split(",");
        return Arrays.asList(items);
    }
}
