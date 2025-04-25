public class BankAccount {
    private double balance;

    public BankAccount(){
        this.balance = 0.0;
    }
    public void deposit(double amount){
        if(amount > 0){
            this.balance += amount;
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
        }
        else{
            throw new IllegalArgumentException("Insufficient Funds");
        }
    }
    public double getBalance(){
        return balance;
    }
}
