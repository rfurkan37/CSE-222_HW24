public class Operator extends Person {
    int wage;
    Customer[] customers = new Customer[100];
    private int customerIndex = 0;

    public Operator(String name, String surname, String address, String phone, int ID, int wage) {
        super(name, surname, address, phone, ID);
        this.wage = wage;
    }

    public void print_operator() {

        System.out.println("----------------------------");
        System.out.println("Name & Surname: " + this.name + " " + this.surname);
        System.out.println("Address: " + this.address);
        System.out.println("Phone: " + this.phone);
        System.out.println("ID: " + this.ID);
        System.out.println("Wage: " + this.wage);
        System.out.println("----------------------------");
        if (customerIndex == 0) {
            System.out.println("This operator doesn't have any customers.");
            System.out.println("----------------------------");
        } else {
            print_customers();
        }
    }

    public void print_customers() {

        for (int i = 0; i < customerIndex; i++) {
            System.out.print("Customer #" + (i + 1));

            if (customers[i] instanceof RetailCustomer) {
                System.out.print(" (a retail customer):\n");
            } else if (customers[i] instanceof CorporateCustomer) {
                System.out.print(" (a corporate customer):\n");
            }
            customers[i].print_customer();
            System.out.println("----------------------------");
                
        }

    }

    private void addCustomer(Customer newCustomer) {
        if (customerIndex < 100) {
            customers[customerIndex] = newCustomer;
            customerIndex++;
        }
    }

    public void define_customers(Customer[] customers) {

        for (Customer customer : customers) {
            if (customer != null && customer.operator_ID == this.ID) {
                addCustomer(customer);
            }
        }
    }

}