import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Person class for the Social Network Analysis program.
 * This class represents a person in the social network.
 * Each person has a name, age, list of hobbies, and a timestamp.
 * The timestamp is the date and time when the person was added to the network.
 */
public class Person {
    /**
     * Name of the person.
     */
    String name;

    /**
     * Age of the person.
     */
    int age;

    /**
     * List of hobbies of the person.
     */
    List<String> hobbies;

    /**
     * Timestamp when the person was added to the network.
     */
    Date timestamp;

    /**
     * Constructor for the Person class.
     *
     * @param name    Name of the person
     * @param age     Age of the person
     * @param hobbies List of hobbies of the person
     */
    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        this.timestamp = new Date();
    }

    /**
     * Returns a string representation of the person.
     *
     * @return String representation of the person
     */
    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ")";
    }

    /**
     * Returns the name of the person.
     *
     * @return Name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the person.
     *
     * @return Age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the list of hobbies of the person.
     *
     * @return List of hobbies of the person
     */
    public List<String> getHobbies() {
        return hobbies;
    }

    /**
     * Returns the timestamp when the person was added to the network.
     *
     * @return Timestamp when the person was added to the network
     */
    public String getTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(timestamp);
    }

    /**
     * Sets the name of the person.
     *
     * @param name Name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the person.
     *
     * @param age Age of the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the list of hobbies of the person.
     *
     * @param hobbies List of hobbies of the person
     */
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * Sets the timestamp when the person was added to the network.
     *
     * @param timestamp Timestamp when the person was added to the network
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


}
