import java.util.Map;

public class encryptor {
    private final Map<Character, Map<Character, Character>> map;
    private final String key;
    private String keystream = "";
    private final String plain_text;
    private String cipher_text = "";

    public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
        this.map = _map;
        this.key = _key;
        this.plain_text = text;
    }

    public void encrypt() {
        generate_keystream();
        generate_cipher_text();
    }

    /**
     * Generate the keystream based on the length of the plaintext
     */
    private void generate_keystream() {
        int textLength = plain_text.length();

        // Repeat the key until its length is at least equal to the plaintext length
        while (keystream.length() < textLength) {
            keystream += key;
        }

        // Trim the keystream to match the length of the plaintext
        keystream = keystream.substring(0, textLength);
    }

    /**
     * Generate the ciphertext based on the keystream and the plaintext
     * There is no keySet requirement for this method.
     * Libraries not included. 
     */
    private void generate_cipher_text() {
        int textLength = plain_text.length();

        for (int i = 0; i < textLength; i++) {
            char rowIndicator = plain_text.charAt(i);
            char columnIndicator = keystream.charAt(i);

            // Find the corresponding ciphertext letter from the table
            char encryptedChar = map.get(rowIndicator).get(columnIndicator);
            cipher_text += encryptedChar;
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
     * Get the ciphertext.
     * @return the ciphertext
     */
    public String get_cipher_text() {
        return cipher_text;
    }
}
