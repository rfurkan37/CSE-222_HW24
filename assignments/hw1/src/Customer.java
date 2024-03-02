public class Customer extends Person {

    Order[] orders = new Order[100];
    private int orderIndex = 0;
    int operator_ID;

    public Customer(String name, String surname, String address, String phone, int ID, int operator_ID) {
        super(name, surname, address, phone, ID);
        this.operator_ID = operator_ID;
    }

    private void addOrder(Order newOrder) {
        if (orderIndex < 100) {
            orders[orderIndex] = newOrder;
            orderIndex++;
        }
    }

    public void print_customer() {

        System.out.println("Name & Surname: " + this.name + " " + this.surname);
        System.out.println("Address: " + this.address);
        System.out.println("Phone: " + this.phone);
        System.out.println("ID: " + this.ID);
        System.out.println("Operator ID: " + this.operator_ID);
        print_orders();
    }

    public void print_orders() {

        for (int i = 0; i < orderIndex; i++) {
            System.out.print("Order #" + (i + 1) + " => ");
            orders[i].print_order();
        }

    }

    public void define_orders(Order[] orders) {
        for (Order order : orders) {
            if (order == null) {
                break;
            } else if (order.customer_ID == this.ID) {
                addOrder(order);
            }
        }
    }
}