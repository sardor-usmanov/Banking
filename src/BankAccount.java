import java.util.Scanner;

public class BankAccount {
    private double balance;

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Default constructor
    public BankAccount() {
        balance = 0.0;
    }

    // Constructor with initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    // Print balance
    public void printBalance() {
        System.out.printf("Current Balance: %.2f%n", balance);
    }

    // Transfer method
    public void transfer(BankAccount target, double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.withdraw(amount);
            target.deposit(amount);
        } else {
            System.out.println("Transfer failed: insufficient funds.");
        }
    }

    // Main for interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount myAccount = new BankAccount();

        while (true) {
            System.out.println("\nChoose an action: deposit / withdraw / balance / exit");
            String action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "deposit":
                    System.out.print("Amount to deposit: ");
                    double dep = scanner.nextDouble();
                    myAccount.deposit(dep);
                    break;

                case "withdraw":
                    System.out.print("Amount to withdraw: ");
                    double with = scanner.nextDouble();
                    myAccount.withdraw(with);
                    break;

                case "balance":
                    myAccount.printBalance();
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command.");
            }

            scanner.nextLine(); // consume newline
        }
    }
}
