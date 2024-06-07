import java.util.*;

public class Test {
    public static void main(String[] args) {
        SocialNetworkGraph network = new SocialNetworkGraph();
        Random rand = new Random();
        String[] firstNames = {"John", "Jane", "Alex", "Chris", "Katie", "Mike", "Sara", "Tom", "Emily", "Daniel"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};
        String[] hobbiesPool = {"Reading", "Hiking", "Gaming", "Cooking", "Swimming", "Traveling", "Photography", "Music", "Sports", "Art"};

        List<String> personNames = new ArrayList<>();

        // Add 100 persons
        for (int i = 0; i < 100; i++) {
            String name = firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
            int age = rand.nextInt(60) + 20; // Ages between 20 and 80
            List<String> hobbies = new ArrayList<>();
            int hobbiesCount = rand.nextInt(3) + 1; // Each person has 1 to 3 hobbies
            for (int j = 0; j < hobbiesCount; j++) {
                hobbies.add(hobbiesPool[rand.nextInt(hobbiesPool.length)]);
            }
            network.addPerson(name, age, hobbies);
            personNames.add(name);
            System.out.println("Person added: " + name + " (Age: " + age + ", Hobbies: " + hobbies + ")");
            System.out.flush();
            try {
                Thread.sleep(1); // 1 millisecond delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Add random friendships based on probability
        for (int i = 0; i < 200; i++) {
            String name1 = personNames.get(rand.nextInt(personNames.size()));
            String name2 = personNames.get(rand.nextInt(personNames.size()));
            if (!name1.equals(name2)) {
                // Add friendship based on probability of shared hobby or close age
                Person person1 = network.getPerson(name1);
                Person person2 = network.getPerson(name2);
                if (person1 != null && person2 != null) {
                    boolean shouldAddFriendship = false;
                    for (String hobby : person1.getHobbies()) {
                        if (person2.getHobbies().contains(hobby)) {
                            shouldAddFriendship = true;
                            break;
                        }
                    }
                    if (Math.abs(person1.getAge() - person2.getAge()) < 10) {
                        shouldAddFriendship = true;
                    }
                    if (shouldAddFriendship) {
                        network.addFriendship(name1, name2);
                        System.out.println("Friendship added between " + name1 + " and " + name2);
                        System.out.flush();
                        try {
                            Thread.sleep(1); // 1 millisecond delay
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        // Test shortest path between random persons
        String personA = personNames.get(rand.nextInt(personNames.size()));
        String personB = personNames.get(rand.nextInt(personNames.size()));
        System.out.println("Shortest path between " + personA + " and " + personB + ":");
        System.out.flush();
        network.findShortestPath(personA, personB);
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test friend suggestions for a random person
        String personC = personNames.get(rand.nextInt(personNames.size()));
        System.out.println("Friend suggestions for " + personC + ":");
        System.out.flush();
        network.suggestFriends(personC, 5);
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test cluster counting
        System.out.println("Number of clusters:");
        System.out.flush();
        network.countClusters();
        try {
            Thread.sleep(2000); // 2 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
