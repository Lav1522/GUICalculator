// # Mini ATM project
import java.util.Scanner;

class Account {
    private String username;
    private String pin;
    private double balance;

    public Account(String username, String pin, double balance) {
        this.username = username;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

public class ATM {
    private Account account;
    private Scanner scanner;

    public ATM(Account account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
        }
    }

    public static void main(String[] args) {
        Account userAccount = new Account("username", "1234", 1000); // Replace with actual account details
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}

