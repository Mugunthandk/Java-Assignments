import java.util.Scanner;
class Delivery {
    double orderAmount;
    public Delivery(double orderAmount) { this.orderAmount = orderAmount; }
    public double calculateDeliveryCharge() { return 0.0; }
}
class RegularDelivery extends Delivery {
    public RegularDelivery(double orderAmount) { super(orderAmount); }
    @Override
    public double calculateDeliveryCharge() { return orderAmount + 40.0; }
}
class ExpressDelivery extends Delivery {
    public ExpressDelivery(double orderAmount) { super(orderAmount); }
    @Override
    public double calculateDeliveryCharge() { return orderAmount + 80.0 + (orderAmount * 5 / 100); }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int deliveryType = sc.nextInt();
        double orderAmount = sc.nextDouble();
        Delivery delivery = null;
        if(deliveryType == 1) delivery = new RegularDelivery(orderAmount);
        else if(deliveryType == 2) delivery = new ExpressDelivery(orderAmount);
        
        if(delivery != null) {
            System.out.printf("%.2f\n", delivery.calculateDeliveryCharge());
        }
        sc.close();
    }
}