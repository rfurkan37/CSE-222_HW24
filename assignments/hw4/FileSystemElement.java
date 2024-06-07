import java.sql.Timestamp;

/**
 * Abstract class representing a file system element.
 */
public abstract class FileSystemElement {
    String name;
    Timestamp dateCreated;
    FileSystemElement parent;

    /**
     * Constructs a new FileSystemElement.
     * @param name The name of the element.
     * @param parent The parent directory.
     */
    public FileSystemElement(String name, FileSystemElement parent){
        this.name = name;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
        this.parent = parent;
    }

    /**
     * Gets the name of the element.
     * @return The name of the element.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the creation timestamp of the element.
     * @return The creation timestamp.
     */
    public Timestamp getDateCreated(){
        return dateCreated;
    }

    /**
     * Gets the parent directory of the element.
     * @return The parent directory.
     */
    public FileSystemElement getParent(){
        return parent;
    }

    

    /**
     * Gets the path of the element relative to a directory.
     * @param directory The directory to which the path is relative.
     * @return The path of the element relative to the directory.
     */
    public String getPath(Directory directory)
    {
        StringBuilder path = new StringBuilder();
        FileSystemElement current = this;

        while (current != null && current != directory.getParent()){
            path.insert(0, "/" + current.getName());
            current = current.getParent();
        }

        return path.toString();
    }
}
