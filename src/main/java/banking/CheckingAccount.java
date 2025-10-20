package banking;

/**
  * CSC372 - Module 1 Critical Thinking
 * Implementing a superclass bank account
 * Clint Ledbetter
 * 25FD-CSC372-1: Programming II
 * Colorado State University Global 
 * Dr. Vanessa Cooper
 * October 12, 2025
 * 
 * The CheckingAccount class overrides and extends the basic function of BankAccount 
 * superclass to allow for overdraft withdrawals, apply a $30 overdraft fee, and add 
 * the account's interest rate to the account summary.
 * 
 */

public class CheckingAccount extends BankAccount {

    private double interestRate;

    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Overdraft withdrawal with fee
    public void processWithdrawal(double amount) {
        double currentBalance = getBalance();

        if (amount <= currentBalance) {
            withdrawal(amount);
        } else {
        	double newBalance = currentBalance - amount - 30.0;
            System.out.println("Overdraft occurred! Withdrawal of $" + amount + " plus $30 fee.");
            System.out.println("New balance: $" + newBalance);
        }
    }

    // Display BankAccount summary with interest rate added
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
