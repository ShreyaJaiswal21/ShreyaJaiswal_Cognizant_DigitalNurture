public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.displayCustomer("x1y2z3");
    }
}
