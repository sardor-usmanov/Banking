import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("Choose an action: deposit / withdraw / balance / exit");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "create":
                    System.out.print("Enter initial balance: ");
                    double init = scanner.nextDouble();
                    BankAccount acc = new BankAccount(init);
                    accounts.add(acc);
                    System.out.println("Account created. ID: " + (accounts.size() - 1));
                    scanner.nextLine();
                    break;
                case "deposit":
                    System.out.print("Enter account ID: ");
                    int depId = scanner.nextInt();
                    if (depId >= 0 && depId < accounts.size()) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = scanner.nextDouble();
                        accounts.get(depId).deposit(dep);  // <-- to‘g‘ri ishlaydi
                    } else {
                        System.out.println("Invalid account ID.");
                    }
                    scanner.nextLine();
                    break;

                case "withdraw":
                    System.out.print("Enter account ID: ");
                    int wdId = scanner.nextInt();
                    if (wdId >= 0 && wdId < accounts.size()) {
                        System.out.print("Enter amount to withdraw: ");
                        double wd = scanner.nextDouble();
                        accounts.get(wdId).withdraw(wd);
                    } else {
                        System.out.println("Invalid account ID.");
                    }
                    scanner.nextLine();
                    break;

                case "balance":
                    System.out.print("Enter account ID: ");
                    int bId = scanner.nextInt();
                    if (bId >= 0 && bId < accounts.size()) {
                        accounts.get(bId).printBalance();
                    } else {
                        System.out.println("Invalid account ID.");
                    }
                    scanner.nextLine();
                    break;

                case "export":
                    try (PrintWriter writer = new PrintWriter("accounts.txt")) {
                        for (int i = 0; i < accounts.size(); i++) {
                            writer.println("Account #" + i + ": Balance = " + accounts.get(i).getBalance());
                        }
                        System.out.println("Exported to accounts.txt");
                    } catch (Exception e) {
                        System.out.println("Error exporting: " + e.getMessage());
                    }
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
