import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Represents a directory in the file system.
 */
public class Directory extends FileSystemElement{
    private LinkedList<FileSystemElement> children;

    /**
     * Constructs a new Directory.
     * @param name The name of the directory.
     * @param parent The parent directory.
     */
    public Directory(String name, FileSystemElement parent){
        super(name, parent);
        children = new LinkedList<>();
    }

    /**
     * Adds a child element to the directory.
     * @param child The child element to add.
     */
    public void addChild(FileSystemElement child){
        children.add(child);
    }

    /**
     * Removes a child element from the directory.
     * @param child The child element to remove.
     */
    public void removeChild(FileSystemElement child){
        children.remove(child);
    }

    /**
     * Gets the list of children elements in the directory.
     * @return The list of children elements.
     */
    public LinkedList<FileSystemElement> getChildren(){
        return children;
    }

    /**
     * Gets a child element by name.
     * @param name The name of the child element to get.
     * @return The child element with the specified name, or null if not found.
     */
    public FileSystemElement getChildByName(String name){
        for(FileSystemElement child : children){
            if(child.getName().equals(name)){
                return child;
            }
        }
        return null;
    }

    /**
     * Gets the full path of the directory.
     * @return The full path of the directory.
     */
    public String getPath() {
        StringBuilder path = new StringBuilder();
        FileSystemElement current = this;

        while (current != null) {
            if (path.length() > 0) {
                path.insert(0, "/");
            }
            path.insert(0, current.getName());
            current = current.getParent();
        }

        return path.toString();
    }

    /**
     * Prints the contents of the directory.
     */
    public void printSortedDirectoryByTimestamp() {
        List<FileSystemElement> sortedChildren = new ArrayList<>(children);

        Collections.sort(sortedChildren, new Comparator<FileSystemElement>() {
            @Override
            public int compare(FileSystemElement element1, FileSystemElement element2) {
                return element1.getDateCreated().compareTo(element2.getDateCreated());
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Sorted contents of " + getPath() + " by date created:");
        for (FileSystemElement child : sortedChildren) {
            String type = child instanceof Directory ? "/" : "";
            String date = dateFormat.format(child.getDateCreated());
            System.out.println("* " + child.getName() + type + " (" + date + ")");
        }
    }

}
