import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
    private final Set<Character> english_alphabet = new LinkedHashSet<Character>();
    private final Map<Character, Map<Character, Character>> map = new HashMap<Character, Map<Character, Character>>();

    /**
     * Constructor for the alphabet class.
     */
    public alphabet() {
        // do not edit this method
        fill_english_alphabet();
        fill_map();
    }

    /**
     * Fill the set with the English alphabet.
     */
    private void fill_english_alphabet() {
        // do not edit this method
        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
            english_alphabet.add(c);
        }
    }

    /**
     * Fill the map with the Vigenere cipher table.
     * The table should be filled with the English alphabet.
     * The first row should be filled with the English alphabet in order.
     * The second row should be filled with the English alphabet in a circular shift by 1.
     * The third row should be filled with the English alphabet in a circular shift by 2.
     * And so on.
     */
    private void fill_map() {
        // You must use the "english_alphabet" variable in this method, to fill the "map" variable.
        // You can define 1 or 2 iterators to iterate through the set items.

        for (char rowIndic : english_alphabet) {
            Map<Character, Character> innerMap = new HashMap<>();

            Iterator<Character> columnIterator = english_alphabet.iterator();
            char currentChar = rowIndic;

            while (columnIterator.hasNext()) {
                char columnIndicator = columnIterator.next();
                innerMap.put(columnIndicator, currentChar);
                currentChar = (char) ((currentChar - 'A' + 1) % 26 + 'A');
            }

            map.put(rowIndic, innerMap);
        }
    }

    /**
     * Print the map.
     */
	public void print_map() {
		// do not edit this method
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for(Character k: map.keySet()) {
			System.out.print("\n" + k + " | ");
			System.out.print(map.get(k).values());
		}
		System.out.println("\n");
		
	}

    /**
     * Get the map.
     * @return the map
     */
    public Map<Character, Map<Character, Character>> get_map() {
        return map;
    }
}