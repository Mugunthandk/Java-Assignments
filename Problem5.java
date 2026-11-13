import java.util.Scanner;
class Employee {
    String employeeName;
    public Employee(String employeeName) { this.employeeName = employeeName; }
    public double calculateBonus() { return 0.0; }
    public double calculateBonus(double amount) { return 0.0; }
}
class TechnicalEmployee extends Employee {
    double basicSalary;
    int rating;
    public TechnicalEmployee(String employeeName, double basicSalary, int rating) {
        super(employeeName);
        this.basicSalary = basicSalary;
        this.rating = rating;
    }
    @Override
    public double calculateBonus() { return basicSalary * rating * 2 / 100; }
    public double calculateBonus(double salary, int employeeRating) {
        return salary * employeeRating * 2 / 100;
    }
}
class SalesEmployee extends Employee {
    double salesAmount;
    public SalesEmployee(String employeeName, double salesAmount) {
        super(employeeName);
        this.salesAmount = salesAmount;
    }
    @Override
    public double calculateBonus() { return salesAmount * 3 / 100; }
    @Override
    public double calculateBonus(double amount) { return amount * 3 / 100; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int employeeType = sc.nextInt();
        String employeeName = sc.next();
        Employee emp = null;
        double totalEarnings = 0.0;
        double bonus = 0.0;
        
        if(employeeType == 1) {
            double basicSalary = sc.nextDouble();
            int rating = sc.nextInt();
            TechnicalEmployee te = new TechnicalEmployee(employeeName, basicSalary, rating);
            bonus = te.calculateBonus();
            totalEarnings = basicSalary + bonus;
            emp = te;
        } else if(employeeType == 2) {
            double salesAmount = sc.nextDouble();
            SalesEmployee se = new SalesEmployee(employeeName, salesAmount);
            bonus = se.calculateBonus();
            totalEarnings = salesAmount + bonus;
            emp = se;
        }
        
        if(emp != null) {
            System.out.println("Employee Name: " + emp.employeeName);
            System.out.printf("Bonus: %.2f\n", bonus);
            System.out.printf("Total Earnings: %.2f\n", totalEarnings);
        }
        sc.close();
    }
}