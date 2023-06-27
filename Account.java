public class Account {
    private String accountName;
    private double interestRate;
    private double balance;

    public Account(String accountName, double interestRate, double startingBalance) {
        this.accountName = accountName;
        this.interestRate = interestRate;
        this.balance = startingBalance;
    }

    public Account(String accountName, double interestRate) {
        this.accountName = accountName;
        this.interestRate = interestRate;
        this.balance = 0;
    }

    public Account (Account a) {
        accountName = a.accountName;
        interestRate = a.interestRate;
        balance = a.balance;
    }

    public void deposit (double dollars) {
        balance += dollars;
    }

    public boolean withdraw (double dollars) {
        if (balance >= dollars) {
            balance -= dollars;
            return true;
        }
        else {
            System.out.println("Error: Insufficient funds.");
            return false;
        }
    }

    public boolean transfer (Account to, double dollars) {
      if (balance >= dollars) {
        withdraw (dollars);
        to.deposit(dollars);
        return true;
      }
      return false;
    }

    public void applyAnnualInterest () {
        balance += balance * interestRate/100;
    }

    public String toString () {
        return String.format("%s has a balance of %.2f, paying %.2f%% interest per year.", accountName, balance, interestRate);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
