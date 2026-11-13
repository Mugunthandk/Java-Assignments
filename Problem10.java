import java.util.Scanner;
class Product {
    int productId;
    String productName;
    double price;
    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    public double calculateDiscount() { return 0.0; }
}
class ElectronicsProduct extends Product {
    public ElectronicsProduct(int productId, String productName, double price) {
        super(productId, productName, price);
    }
    @Override
    public double calculateDiscount() { return price * 0.12; }
}
class ClothingProduct extends Product {
    public ClothingProduct(int productId, String productName, double price) {
        super(productId, productName, price);
    }
    @Override
    public double calculateDiscount() { return price * 0.20; }
}
class GroceryProduct extends Product {
    public GroceryProduct(int productId, String productName, double price) {
        super(productId, productName, price);
    }
    @Override
    public double calculateDiscount() { return price * 0.05; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productType = sc.nextInt();
        int productId = sc.nextInt();
        String productName = sc.next();
        double price = sc.nextDouble();
        Product p = null;
        
        if(productType == 1) p = new ElectronicsProduct(productId, productName, price);
        else if(productType == 2) p = new ClothingProduct(productId, productName, price);
        else if(productType == 3) p = new GroceryProduct(productId, productName, price);
        
        if(p != null) {
            double discount = p.calculateDiscount();
            double finalPrice = p.price - discount;
            System.out.println("Product ID: " + p.productId);
            System.out.println("Product Name: " + p.productName);
            System.out.printf("Discount: %.2f\n", discount);
            System.out.printf("Final Price: %.2f\n", finalPrice);
        }
        sc.close();
    }
}