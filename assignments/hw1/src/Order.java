public class Order {

    String product_name;
    int count;
    int total_price;
    int status;
    int customer_ID;

    public Order(String product_name, int count, int total_price, int status, int customer_ID) {
        this.product_name = product_name;
        this.count = count;
        this.total_price = total_price;
        this.status = status;
        this.customer_ID = customer_ID;
    }

    private String statusToString(int status) throws Exception {

        switch (status) {
            case 0:
                return "Initialized.";
            case 1:
                return "Processing.";
            case 2:
                return "Completed.";
            case 3:
                return "Cancelled.";
            default:
                throw new Exception("Invalid status.");
        }
    }

    public void print_order() {

        try {
            System.out.print("Product Name: " + this.product_name + " - Count: " + this.count + " - Total Price: "
                    + this.total_price + " - Status: " + this.statusToString(this.status) + "\n");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
