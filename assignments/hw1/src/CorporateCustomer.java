public class CorporateCustomer extends Customer {

    String company_name;

    public CorporateCustomer(String name, String surname, String address, String phone, Integer ID, int operator_ID,
            String company_name) {
        super(name, surname, address, phone, ID, operator_ID);
        this.company_name = company_name;
    }

    public void print_customer() {

        System.out.println("Name & Surname: " + this.name + " " + this.surname);
        System.out.println("Address: " + this.address);
        System.out.println("Phone: " + this.phone);
        System.out.println("ID: " + this.ID);
        System.out.println("Operator ID: " + this.operator_ID);
        System.out.println("Company Name: " + this.company_name);
        if (getIndex() > 0) {
            print_orders();
        }
        else
        {
            System.out.println("No orders found.");
        }
    }

}
