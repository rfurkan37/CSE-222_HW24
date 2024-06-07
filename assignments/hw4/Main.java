import java.util.Scanner;

/**
 * Main class for the file system management program.
 
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static FileSystem fileSystem = new FileSystem();

    /**
     * Main method for the file system management program.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    changeDirectory();
                    break;
                case 2:
                    listDirectoryContents();
                    break;
                case 3:
                    createFile();
                    break;
                case 4:
                    createDirectory();
                    break;
                case 5:
                    deleteElement();
                    break;
                case 6:
                    moveElement();
                    break;
                case 7:
                    searchElement();
                    break;
                case 8:
                    printDirectoryTree();
                    break;
                case 9:
                    sortDirectory();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the menu of options for the file system management program.
     * 
     */
    private static void displayMenu() {
        System.out.println("===== File System Management Menu =====");
        System.out.println("1. Change directory");
        System.out.println("2. List directory contents");
        System.out.println("3. Create file");
        System.out.println("4. Create directory");
        System.out.println("5. Delete file/directory");
        System.out.println("6. Move file/directory");
        System.out.println("7. Search file/directory");
        System.out.println("8. Print directory tree");
        System.out.println("9. Sort directory contents");
        System.out.println("10. Exit");
        System.out.print("Please select an option: ");
    }

    /**
     * Gets the user's choice from the menu.
     * @return
     */
    private static int getUserChoice() {
        return scanner.nextInt();
    }

    /**
     * Changes the current directory.
     */
    private static void changeDirectory() {
        System.out.println("Current directory: " + fileSystem.getCurrentDirectory().getPath());
        System.out.print("Enter new directory path: ");
        scanner.nextLine(); // Consume newline character
        String newPath = scanner.nextLine();
        Directory newDirectory = fileSystem.changeDirectory(newPath);
        if (newDirectory != null) {
            fileSystem.setCurrentDirectory(newDirectory);
        }
    }
    
    /**
     * Lists the contents of the current directory.
     * 
     */
    private static void listDirectoryContents() {
        System.out.println("Contents of current directory:");
        fileSystem.listDirectory();
    }

    /**
     * Creates a new file in the current directory.
     */
    private static void createFile() {
        System.out.print("Enter name for new file: ");
        scanner.nextLine(); // Consume newline character
        String fileName = scanner.nextLine();
        fileSystem.createFile(fileName);
    }

    /**
     * Creates a new directory in the current directory.
     */
    private static void createDirectory() {
        System.out.print("Enter name for new directory: ");
        scanner.nextLine(); // Consume newline character
        String directoryName = scanner.nextLine();
        fileSystem.createDirectory(directoryName);
    }

    /**
     * Deletes a file or directory from the current directory.
     */
    private static void deleteElement() {
        System.out.print("Enter name of file/directory to delete: ");
        scanner.nextLine(); // Consume newline character
        String name = scanner.nextLine();
        fileSystem.deleteElement(name);
    }

    /**
     * Moves a file or directory to a new path.
     */
    private static void moveElement() {
        System.out.print("Enter the name of file/directory to move: ");
        scanner.nextLine(); // Consume newline character
        String name = scanner.nextLine();

        System.out.print("Enter new directory path: ");
        String newPath = scanner.nextLine();

        fileSystem.moveElement(name, newPath);
    }

    /**
     * Searches for a file or directory in the file system.
     */
    private static void searchElement() {
        System.out.print("Search query: ");
        scanner.nextLine(); // Consume newline character
        String query = scanner.nextLine();
        FileSystemElement result = fileSystem.searchElement(query);
        if (result != null) {
            System.out.println("Found: " + result.getPath(fileSystem.getCurrentDirectory()));
        } else {
            System.out.println("Not found.");
        }
    }

    /**
     * Prints the directory tree of the file system.
     */
    private static void printDirectoryTree() {
        fileSystem.printDirectoryTree();
    }

    /**
     * Sorts the contents of the current directory by timestamp.
     */
    private static void sortDirectory() {
        fileSystem.getCurrentDirectory().printSortedDirectoryByTimestamp();
    }
}
