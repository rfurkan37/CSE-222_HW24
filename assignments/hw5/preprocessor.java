public class preprocessor {
    private final String initial_string;
    private String preprocessed_string;
        
    public preprocessor(String str) {
        this.initial_string = str;
    }

    /**
     * Preprocess the string.
     */
    public void preprocess() {
        // do not edit this method
        capitalize();
        clean();
    }

    /**
     * Capitalize the string.
     */
    private void capitalize() {
        preprocessed_string = initial_string.toUpperCase();
    }

    /**
     * Remove all non-alphabetic characters from the string.
     */
    private void clean() {
        preprocessed_string = preprocessed_string.replaceAll("[^A-Z]", "");
    }

    /**
     * Get the preprocessed string.
     * @return the preprocessed string
     */
    public String get_preprocessed_string() {
        return preprocessed_string;
    }
}
