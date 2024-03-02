import java.util.Scanner;
import java.io.File;

public class App {
    private static Customer[] allCustomers = new Customer[100];
    private static Operator[] allOperators = new Operator[100];
    private static Order[] allOrders = new Order[100];

    private static int customerIndex = 0;
    private static int operatorIndex = 0;
    private static int orderIndex = 0;

    public static int checkDouble(Customer customer) {

        int flag = 1;
        for (int i = 0; i < customerIndex; i++) {
            if (allCustomers[i] == null && allCustomers[i].ID == customer.ID) {
                flag = 0;
            }
        }

        for (int i = 0; i < operatorIndex; i++) {
            if (allOperators[i] == null && allOperators[i].ID == customer.operator_ID) {
                flag = 0;
            }
        }

        return flag;
    }

    public static int checkDouble(Operator operator) {

        int flag = 1;
        for (int i = 0; i < operatorIndex; i++) {
            if (allOperators[i] == null || allOperators[i].ID == operator.ID) {
                flag = 0;
            }
        }

        for (int i = 0; i < customerIndex; i++) {
            if (allCustomers[i] == null && allCustomers[i].ID == operator.ID) {
                flag = 0;
            }
        }

        return flag;
    }

    public static String check(String str) throws Exception {
        if (str == null) {
            throw new Exception();
        } else {
            return str;
        }
    }

    public static int check(int num, int statusFlag) throws Exception {
        switch (statusFlag) {
            case 0:
                if (num <= 0) {
                    throw new Exception();
                } else {
                    return num;
                }
            case 1:
                if (num < 0 || num > 3) {
                    throw new Exception();
                } else {
                    return num;
                }
            default:
                throw new Exception();
        }
    }

    public static void addCustomer(Customer newCustomer) {
        try {
            if (customerIndex < 100 && newCustomer != null && checkDouble(newCustomer) == 1) {
                allCustomers[customerIndex] = newCustomer;
                customerIndex++;
            }
        } catch (Exception e) {

        }
    }

    public static void addOperator(Operator newOperator) {
        try {
            if (operatorIndex < 100 && newOperator != null && checkDouble(newOperator) == 1) {
                allOperators[operatorIndex] = newOperator;
                operatorIndex++;
            }
        } catch (Exception e) {
        }
    }

    public static void addOrder(Order newOrder) {
        try {
            if (orderIndex < 100 && newOrder != null) {
                allOrders[orderIndex] = newOrder;
                orderIndex++;
            }
        } catch (Exception e) {

        }
    }

    public static void getDataFromLine(String[] dataStrings) throws Exception {

        if (dataStrings == null) {

        } else {
            switch (dataStrings[0]) {
                case "order":
                    Order newOrder = null;

                    try {
                        newOrder = new Order(check(dataStrings[1]), check(Integer.parseInt(dataStrings[2]), 0),
                                check(Integer.parseInt(dataStrings[3]), 0), check(Integer.parseInt(dataStrings[4]), 1),
                                check(Integer.parseInt(dataStrings[5]), 0));
                    } catch (Exception e) {

                    }

                    addOrder(newOrder);
                    break;

                case "retail_customer":
                    RetailCustomer newRetailCustomer = null;

                    try {
                        newRetailCustomer = new RetailCustomer(check(dataStrings[1]), check(dataStrings[2]),
                                check(dataStrings[3]),
                                check(dataStrings[4]), check(Integer.parseInt(dataStrings[5]), 0),
                                check(Integer.parseInt(dataStrings[6]), 0));
                    } catch (Exception e) {

                    }

                    addCustomer(newRetailCustomer);
                    break;

                case "corporate_customer":
                    CorporateCustomer newCorporateCustomer = null;

                    try {
                        newCorporateCustomer = new CorporateCustomer(check(dataStrings[1]), check(dataStrings[2]),
                                check(dataStrings[3]), check(dataStrings[4]),
                                check(Integer.parseInt(dataStrings[5]), 0),
                                check(Integer.parseInt(dataStrings[6]), 0), check(dataStrings[7]));

                    } catch (Exception e) {

                    }
                    addCustomer(newCorporateCustomer);
                    break;

                case "operator":
                    Operator newOperator = null;

                    try {
                        newOperator = new Operator(check(dataStrings[1]), check(dataStrings[2]), check(dataStrings[3]),
                                check(dataStrings[4]), check(Integer.parseInt(dataStrings[5]), 0),
                                check(Integer.parseInt(dataStrings[6]), 0));
                    } catch (Exception e) {

                    }

                    if (checkDouble(newOperator) == 1)
                        addOperator(newOperator);
                    break;

                default:
                    break;
            }
        }

    }

    public static void customFileRead() {
        Scanner scanner = null;

        try {
            File text = new File("src/content.txt");
            scanner = new Scanner(text);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                getDataFromLine(tokens);
            }
        } catch (Exception e) {

        } finally {
            scanner.close();
        }

    }

    public static void saveAllData() {
        for (Customer customer : allCustomers) {
            if (customer != null) {
                customer.define_orders(allOrders);
            }
        }

        for (Operator operator : allOperators) {
            if (operator != null) {
                operator.define_customers(allCustomers);
            }
        }

    }

    public static void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your ID...");
        int ID = scanner.nextInt();
        int flag = 0;

        for (Operator operator : allOperators) {
            if (operator != null && operator.ID == ID) {
                flag = 1;
                System.out.println("*** Operator Screen ***");
                operator.print_operator();
            }
        }

        if (flag == 0) {
            for (Customer customer : allCustomers) {
                if (customer != null && customer.ID == ID) {
                    flag = 1;
                    System.out.println("*** Customer Screen ***");
                    customer.print_customer();
                }
            }

            if (flag == 0)
                System.out.println("No operator/customer found with ID " + ID +". Please try again.");
        }

        scanner.close();
    }

    public static void main(String[] args) throws Exception {
        customFileRead();
        saveAllData();
        userInput();
    }
}
