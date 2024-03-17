import java.util.ArrayList;
import java.util.Scanner;

class AtmUser {
    private String userId;
    private String userPin;
    private double balance;

    public AtmUser(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public boolean validateCredentials(String userIdEntered, String userPinEntered) {
        return this.userId.equals(userIdEntered) && this.userPin.equals(userPinEntered);
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        balance += amount;
    }
}

 class ATM_App {
    private AtmUser user;
    private ArrayList<String> transactionHistory;

    public ATM_App(String userId, String userPin, double balance) {
        this.user = new AtmUser(userId, userPin, balance);
        this.transactionHistory = new ArrayList<>();
    }

    private void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private void withdraw(double amount, Scanner scanner) {
        if (amount <= user.getBalance()) {
            user.updateBalance(-amount);
            transactionHistory.add("Withdrawal: R" + amount);
            System.out.println("R" + amount + " was withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    private void deposit(double amount, Scanner scanner) {
        user.updateBalance(amount);
        transactionHistory.add("Deposit: R" + amount);
        System.out.println("R" + amount + " was deposited successfully.");
    }

    private void transfer(double amount, String recipient, Scanner scanner) {
        if (amount <= user.getBalance()) {
            user.updateBalance(-amount);
            transactionHistory.add("Transfer: R" + amount + " to " + recipient);
            System.out.println("R" + amount + " has been successfully transferred to " + recipient + ".");
            System.out.println("Remaining balance: R" + user.getBalance());
        } else {
            System.out.println("Insufficient funds for transfer!");
        }
    }

    private void showBalance() {
        System.out.println("Your current balance: R" + user.getBalance());
    }

    public void functionalities() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM.");
        System.out.print("Please enter your user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Please enter your PIN: ");
        String userPin = scanner.nextLine();

        if (user.validateCredentials(userId, userPin)) {
            System.out.println(userId + " Login Successful.");

            boolean exit = false;

            while (!exit) {
                System.out.println("Choose any option you want to perform:");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. View Balance");
                System.out.println("6. Quit");

                int userChoice;
                try {
                    userChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1-6.");
                    continue;
                }

                if (userChoice == 1) {
                    showTransactionHistory();
                } else if (userChoice == 2) {
                    System.out.print("Enter the amount you would like to withdraw: ");
                    double withdrawalAmount = Double.parseDouble(scanner.nextLine());
                    withdraw(withdrawalAmount, scanner);
                } else if (userChoice == 3) {
                    System.out.print("Enter the amount you want to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    deposit(depositAmount, scanner);
                } else if (userChoice == 4) {
                    System.out.print("Enter the amount you want to transfer: ");
                    double transferAmount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter the recipient's name: ");
                    String recipientName = scanner.nextLine();
                    transfer(transferAmount, recipientName, scanner);
                } else if (userChoice == 5) {
                    showBalance();
                } else if (userChoice == 6) {
                    exit = true;
                    System.out.println("Thank you " + userId + " for using our ATM. Goodbye!!!");
                } else {
                    System.out.println("You have entered an invalid choice. Please enter a number between 1-6.");
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }

        scanner.close();
    }
 
    public static void main(String[] args) {
        ATM_App atm = new ATM_App("Yinhla", "2003", 1000.0); // Predefined user ID, PIN, and initial balance
        atm.functionalities();
    }
}
