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
 * The BankDemo class serves as the main driver program for 
 * testing the BankAccount and CheckingAccount classes.
 * It demonstrates creating a account, handling deposits, 
 * withdrawals, and overdrafts with fee.
 * Displays account summary for different test cases 
 * to verify correct inheritance, behavior, and output.
 * 
 */

public class BankDemo {
    public static void main(String[] args) {
    	// BankAccount tests:
    	
    	// test starting with zero balance for normal deposit then withdrawal
        System.out.println("=== TEST CASE 1: BankAccount ===");
        BankAccount account1 = new BankAccount("Clint", "Ledbetter", 1001);
        account1.deposit(500);
        account1.withdrawal(200);
        account1.accountSummary();
        
        // edge test for zero balance
        System.out.println("\n=== TEST CASE 2: BankAccount Edge Case for $0 Balance – Deposit and Withdrawals ===");
        BankAccount account2 = new BankAccount("Bruce", "Willis", 4001);
        account2.deposit(1000);
        account2.withdrawal(100);
        account2.withdrawal(900); // zeroes balance
        account2.accountSummary();
        
        // test for negative deposit
        System.out.println("\n=== TEST CASE 3: BankAccount Invalid Negative Deposit ===");
        BankAccount account3 = new BankAccount("David", "King", 5001);
        account3.deposit(-200); // should show warning message
        account3.accountSummary();

        // test for negative withdrawal
        System.out.println("\n=== TEST CASE 4: BankAccount Invalid Negative Withdrawal ===");
        account3.withdrawal(-100); // should show warning message
        account3.accountSummary();
        
        // test for attempt to withdraw more than the available balance
        System.out.println("\n--- Test Case 5: BankAccount Insufficient Funds Withdrawal ---");
        BankAccount account4 = new BankAccount("Brad", "Pitt", 1003);
        account4.deposit(50.00);  // Deposit a small amount
        System.out.println("Current Balance: $" + account4.getBalance());
        System.out.println("Attempting to withdraw $100...");
        account4.withdrawal(100.00); // Should trigger insufficient funds message
        account4.accountSummary();
        
        // test for BankAccount with extended CheckingAccount:
        
        // test starting with zero balance for normal deposit then withdrawal and added interest rate to summary
        System.out.println("\n=== TEST CASE 6: CheckingAccount (No Overdraft) ===");
        CheckingAccount checking1 = new CheckingAccount("Jane", "Doe", 2001, 1.5);
        checking1.deposit(300);
        checking1.processWithdrawal(150); // no overdraft
        checking1.displayAccount();
        
        // test for overdraft withdrawal with fee applied
        System.out.println("\n=== TEST CASE 7: CheckingAccount (Overdraft Fee Applied) ===");
        CheckingAccount checking2 = new CheckingAccount("John", "Smith", 3001, 2.0);
        checking2.deposit(100);
        checking2.processWithdrawal(150); // triggers overdraft fee
        checking2.displayAccount();
    }
}
