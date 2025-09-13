import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * Main class to read input file and perform performance analysis
 */
public class Main {
    /**
     * Main method to read input file and perform performance analysis
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <input_file>");
            return;
        }

        String inputFile = args[0];
        StockDataManager manager = new StockDataManager();

        File file = new File(inputFile);
        if (!file.exists() || !file.canRead()) {
            System.out.println("Cannot read the file: " + inputFile);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    processCommand(line, manager);
                } catch (Exception e) {
                    System.err.println("Error processing command: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + inputFile + " - " + e.getMessage());
        }

        // Perform a simple performance analysis
       // performPerformanceAnalysis(manager, 15000);
    }

    /**
     * Process a single command from the input file
     * @param line Command line
     * @param manager StockDataManager object
     */
    private static void processCommand(String line, StockDataManager manager) {
        String[] tokens = line.split(" ");
        if (tokens.length == 0) {
            return;
        }

        String command = tokens[0];

        try {
            switch (command) {
                case "ADD":
                    if (tokens.length == 5) {
                        manager.addOrUpdateStock(tokens[1], Double.parseDouble(tokens[2]), Long.parseLong(tokens[3]),
                                Long.parseLong(tokens[4]));
                        System.out.println("Stock added or updated: " + tokens[1]);
                    } else {
                        System.out.println("Invalid ADD command format");
                    }
                    break;
                case "REMOVE":
                    if (tokens.length == 2) {
                        manager.removeStock(tokens[1]);
                        System.out.println("Stock removed: " + tokens[1]);
                    } else {
                        System.out.println("Invalid REMOVE command format");
                    }
                    break;
                case "SEARCH":
                    if (tokens.length == 2) {
                        Stock stock = manager.searchStock(tokens[1]);
                        if (stock != null) {
                            System.out.println(stock);
                        } else {
                            System.out.println("Stock not found: " + tokens[1]);
                        }
                    } else {
                        System.out.println("Invalid SEARCH command format");
                    }
                    break;
                case "UPDATE":
                    if (tokens.length == 5) {
                        manager.updateStock(tokens[1], Double.parseDouble(tokens[2]), Long.parseLong(tokens[3]),
                                Long.parseLong(tokens[4]));
                        System.out.println("Stock updated: " + tokens[1]);
                    } else {
                        System.out.println("Invalid UPDATE command format");
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in command: " + line);
        }
    }

    /**
     * Perform performance analysis for ADD, SEARCH and REMOVE operations
     * @param manager StockDataManager object
     * @param size Number of operations to perform
     */
    private static void performPerformanceAnalysis(StockDataManager manager, int size) {
        long startTime, endTime;

        // Measure time for ADD operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.addOrUpdateStock("SYM" + i, Math.random() * 100, (long) (Math.random() * 1000000), (long) (Math.random() * 1000000000));
        }
        endTime = System.nanoTime();
        System.out.println("Average ADD time: " + (endTime - startTime) / size + " ns");

        // Measure time for SEARCH operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.searchStock("SYM" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Average SEARCH time: " + (endTime - startTime) / size + " ns");

        // Measure time for REMOVE operation
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            manager.removeStock("SYM" + i);
        }
        endTime = System.nanoTime();
        System.out.println("Average REMOVE time: " + (endTime - startTime) / size + " ns");
    }


    /**
     * Calculate the average of a list of times
     * @param times List of times
     * @return  Average time
     */
    private static long calculateAverage(List<Long> times) {
        long sum = 0;
        for (Long time : times) {
            sum += time;
        }
        return sum / times.size();
    }
}
