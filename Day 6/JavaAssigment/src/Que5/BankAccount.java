package Que5;

public class BankAccount {
	 private double balance;
	 
	 public BankAccount(double initialBalance) {
		  this.balance = initialBalance;
	}

	 public synchronized void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited: " + amount);
	        } else {
	            System.out.println("Invalid deposit amount: " + amount);
	        }
	    }
	 
	    public synchronized void withdraw(double amount) {
	        if (amount > 0 && balance >= amount) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	        } else {
	            System.out.println("Invalid withdrawal amount: " + amount);
	        }
	    }
	    
	    public synchronized double checkBalance() {
	        return balance;
	    }
	    
	    
	    public static void main(String[] args) {
	        BankAccount account = new BankAccount(1000);

	        Thread depositThread1 = new Thread(() -> {
	            for (int i = 0; i < 1000; i++) {
	                account.deposit(10);
	            }
	        });

	        Thread depositThread2 = new Thread(() -> {
	            for (int i = 0; i < 1000; i++) {
	                account.deposit(20);
	            }
	        });

	        Thread withdrawThread1 = new Thread(() -> {
	            for (int i = 0; i < 500; i++) {
	                account.withdraw(15);
	            }
	        });

	        Thread withdrawThread2 = new Thread(() -> {
	            for (int i = 0; i < 500; i++) {
	                account.withdraw(25);
	            }
	        });

	        depositThread1.start();
	        depositThread2.start();
	        withdrawThread1.start();
	        withdrawThread2.start();

	        try {
	            depositThread1.join();
	            depositThread2.join();
	            withdrawThread1.join();
	            withdrawThread2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Final balance: " + account.checkBalance());
		}
}
