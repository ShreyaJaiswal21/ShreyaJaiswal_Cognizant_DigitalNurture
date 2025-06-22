public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.pay(1000.00);

        context.setPaymentStrategy(new PayPalPayment());
        context.pay(700.00);
    }
}
