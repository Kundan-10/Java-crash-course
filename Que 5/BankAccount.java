class BankAccount{

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public double getBalance(){
          return balance;
    }
   
    public void setBalance(double newBalance){
        if(newBalance >= 0){
            balance=newBalance;
        }else{
            System.out.println("balance cannot be negative");
        }
    }

     public void setAccountNumber(String newAccountNumber){
        accountNumber=newAccountNumber;
     }
    

    public static void main(String []args){
        BankAccount account = new BankAccount("1234567890", 1000.0);

        account.setBalance(-10);
        System.out.println(" Account Details:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());

    }

}