import java.util.Scanner;
interface Payment {
    double calculateFee(double amount);
}
class CreditCardPayment implements Payment {
    public double calculateFee(double amount) { return amount * 0.02; }
}
class UpiPayment implements Payment {
    public double calculateFee(double amount) { return amount * 0.005; }
}
class WalletPayment implements Payment {
    public double calculateFee(double amount) { return amount * 0.01; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int paymentType = sc.nextInt();
        double paymentAmount = sc.nextDouble();
        Payment payment = null;
        if(paymentType == 1) payment = new CreditCardPayment();
        else if(paymentType == 2) payment = new UpiPayment();
        else if(paymentType == 3) payment = new WalletPayment();
        
        if(payment != null) {
            double fee = payment.calculateFee(paymentAmount);
            double finalAmount = paymentAmount + fee;
            System.out.printf("Payment Amount: %.2f\n", paymentAmount);
            System.out.printf("Transaction Fee: %.2f\n", fee);
            System.out.printf("Final Amount: %.2f\n", finalAmount);
        }
        sc.close();
    }
}