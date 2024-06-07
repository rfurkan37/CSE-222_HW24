import java.util.Map;
import java.util.Iterator;

public class decryptor {
    private final Map<Character, Map<Character, Character>> map;
    private final String key;
    private String keystream = "";
    private String plain_text = "";
    private final String cipher_text;

    public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
        this.map = _map;
        this.key = _key;
        this.cipher_text = text;
    }

    public void decrypt() {
        // do not edit this method
        generate_keystream();
        generate_plain_text();
    }

    private void generate_keystream() {        // Generate the keystream based on the length of the ciphertext
        int textLength = cipher_text.length();

        // Repeat the key until its length is at least equal to the ciphertext length
        while (keystream.length() < textLength) {
            keystream += key;
        }

        // Trim the keystream to match the length of the ciphertext
        keystream = keystream.substring(0, textLength);
    }


    /**
     * Generate the plaintext based on the keystream and the ciphertext
     */
    private void generate_plain_text() {
        // You must use map.get(x).keySet() with an iterator in this method
        Iterator<Character> keystreamIterator = keystream.chars().mapToObj(c -> (char) c).iterator();
        Iterator<Character> ciphertextIterator = cipher_text.chars().mapToObj(c -> (char) c).iterator();
    
        while (keystreamIterator.hasNext() && ciphertextIterator.hasNext()) { // Iterate through the keystream and the ciphertext
            char columnIndicator = keystreamIterator.next();
            char ciphertextChar = ciphertextIterator.next();
    
            // Find the corresponding plaintext letter from the table
            for (Character key : map.keySet()) {
                Iterator<Character> keySetIterator = map.get(key).keySet().iterator();
                while (keySetIterator.hasNext()) {
                    if (keySetIterator.next().equals(columnIndicator) && map.get(key).get(columnIndicator).equals(ciphertextChar)) {
                        plain_text += key;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Get the keystream.
     * @return the keystream
     */
    public String get_keystream() {
        return keystream;
    }

    /**
     * Get the plaintext.
     * @return the plaintext
     */
    public String get_plain_text() {
        return plain_text;
    }
}
