import java.util.Scanner;
class BankAccount {
    int accountNumber;
    double balance;
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public double calculateFinalBalance() { return balance; }
}
class SavingsAccount extends BankAccount {
    double interestRate;
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    @Override
    public double calculateFinalBalance() { return balance + (balance * interestRate / 100); }
}
class CurrentAccount extends BankAccount {
    double overdraftLimit;
    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public double calculateFinalBalance() { return balance + overdraftLimit; }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int accountType = sc.nextInt();
        int accountNumber = sc.nextInt();
        double balance = sc.nextDouble();
        BankAccount account = null;
        if(accountType == 1) {
            double interestRate = sc.nextDouble();
            account = new SavingsAccount(accountNumber, balance, interestRate);
        } else if(accountType == 2) {
            double overdraftLimit = sc.nextDouble();
            account = new CurrentAccount(accountNumber, balance, overdraftLimit);
        }
        if(account != null) {
            System.out.printf("%.2f\n", account.calculateFinalBalance());
        }
        sc.close();
    }
}