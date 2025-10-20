package banking;

/**
 * The BankAccount class serves as a superclass representing a general bank account.
 * It maintains basic account details such as the customer's name, account ID, and balance.
 * This class provides core functionality including deposit and withdrawal operations,
 * balance retrieval, and a summary method to display basic account information.
 * 
 * CSC372 - Module 1 Critical Thinking
 * Implementing a superclass bank account
 * Clint Ledbetter
 * 25FD-CSC372-1: Programming II
 * Colorado State University Global 
 * Dr. Vanessa Cooper
 * October 12, 2025
 */public class BankAccount {

    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;
    //Methods:
    // Default constructor - initializes balance to zero
    public BankAccount() {
        this.balance = 0.0;
    }

    // Constructor with parameters
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal method
    public void withdrawal(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
        } else if (amount > 0 && balance < amount) {
            System.out.println("Insufficient funds for withdrawal of $" + amount);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Display account summary
    public void accountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account Owner: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}
