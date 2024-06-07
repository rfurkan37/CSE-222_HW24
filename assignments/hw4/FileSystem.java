import java.util.*;

/**
 * Represents a file system.
 */
public class FileSystem {
    private final Directory root;
    private Directory currentDirectory;

    /**
     * Constructs a new FileSystem with root directory.
     */
    public FileSystem() {
        this.root = new Directory("root", null);
        this.currentDirectory = root;
    }

    /**
     * Sets the root directory of the file system.
     * @param directory The root directory.
     */
    public void setCurrentDirectory(Directory directory) {
        this.currentDirectory = directory;
    }

    /**
     * Changes the current directory.
     * 
     * @param path The path to the new directory.
     * @return The new current directory, or the current directory if the path is invalid.
     * 
     */
    public Directory changeDirectory(String path) {
        String[] directories = path.split("/");
        if (directories[0].equals("root")) {
            System.out.println("Changing to root directory");
            return this.root;
        }
        Directory parent = this.root;
        for (String directory : directories) {
            if (!directory.isEmpty()) {
                System.out.println("Searching for directory: " + directory);
                LinkedList<FileSystemElement> children = parent.getChildren();
                boolean found = false;
                for (FileSystemElement child : children) {
                    if (child instanceof Directory && child.getName().equals(directory)) {
                        parent = (Directory) child;
                        found = true;
                        System.out.println("Found directory: " + directory);
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Directory " + directory + " not found");
                    return parent;
                }
            }
        }
        return parent;
    }

    /**
     * Lists the contents of the current directory.
     */
    public void listDirectory() {
        for (FileSystemElement child : currentDirectory.getChildren()) {
            System.out.println(child.getName());
        }
    }

    /**
     * Creates a new file in the current directory.
     * 
     * @param name The name of the file to create.
     */
    public void createFile(String name) {
        File file = new File(name, currentDirectory);
        currentDirectory.addChild(file);
    }

    /**
     * Creates a new directory in the current directory.
     * 
     * @param name The name of the directory to create.
     */
    public void createDirectory(String name) {
        Directory dir = new Directory(name, currentDirectory);
        currentDirectory.addChild(dir);
    }

    /**
     * Deletes a file or directory from the current directory.
     * 
     * @param name The name of the file or directory to delete.
     */
    public void deleteElement(String name) {
        FileSystemElement element = currentDirectory.getChildByName(name);

        if (element == null) {
            System.out.println("Error: " + name + " not found.");
            return;
        }

        currentDirectory.removeChild(element);
    }

    /**
     * Moves a file or directory to a new path.
     * 
     * @param name    The name of the file or directory to move.
     * @param newPath The new path to move the file or directory to.
     */
    public void moveElement(String name, String newPath) {
        FileSystemElement element = currentDirectory.getChildByName(name);

        if (element == null) {
            System.out.println("Error: " + name + " not found.");
            return;
        }

        String path = element.getPath(currentDirectory);
        currentDirectory.removeChild(element);

        Directory newDirectory = changeDirectory(newPath);
        if (newDirectory != null) {
            newDirectory.addChild(element);
            element.parent = newDirectory;
        }

        changeDirectory(path);
    }

    /**
     * Searches for a file or directory recursively starting from the root.
     * 
     * @param name The name of the file or directory to search for.
     * @return The FileSystemElement with the specified name, or null if not found.
     */
    public FileSystemElement searchElement(String name) {
        return findElement(root, name);
    }

    /**
     * Recursive helper method to search for a file or directory within a directory.
     * 
     * @param directory The directory to search within.
     * @param name      The name of the file or directory to search for.
     * @return The FileSystemElement with the specified name, or null if not found.
     */
    private FileSystemElement findElement(Directory directory, String name) {
        for (FileSystemElement child : directory.getChildren()) {
            if (child.getName().equals(name)) {
                return child; // Found the element
            } else if (child instanceof Directory) {
                FileSystemElement found = findElement((Directory) child, name);
                if (found != null) {
                    return found; // Found the element in a subdirectory
                }
            }
        }
        return null; // Element not found in this directory
    }

    /**
     * Prints the directory tree starting from the root.
     */
    public void printDirectoryTree() {
        printDirectoryTree(root, 0);
    }

    /**
     * Recursive helper method to print the directory tree.
     * 
     * @param directory The directory to print.
     * @param level     The indentation level.
     */
    private void printDirectoryTree(Directory directory, int level) {
        // Print current directory
        for (int i = 0; i < level; i++) {
            System.out.print("|   "); // Indentation
        }
        
        System.out.println(
                "|-- " + directory.getName() + (directory == this.currentDirectory ? "/ (Current Directory)" : ""));

        // Check if directory has children
        List<FileSystemElement> children = directory.getChildren();
        if (children.isEmpty()) {
            // Print a line to indicate an empty directory
            for (int i = 0; i < level + 1; i++) {
                System.out.print("|   "); // Indentation
            }
            System.out.println("|-- (empty)");
        } else {
            // Print children
            for (FileSystemElement child : children) {
                if (child instanceof Directory) {
                    printDirectoryTree((Directory) child, level + 1); // Recursive call for subdirectory
                } else {
                    for (int i = 0; i < level + 1; i++) {
                        System.out.print("|   "); // Indentation
                    }
                    System.out.println("|-- " + child.getName()); // Print file
                }
            }
        }
    }

    /**
     * Returns the current directory.
     * 
     * @return The current directory.
     */
    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    

}
