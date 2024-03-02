package at.htlhl.sew.exceptionhandlingdemo.creditcard;

public class CreditCard {
    private final double limit;
    private double balance;

    public CreditCard(double balance, double limit) {
        this.balance = balance;
        this.limit = limit;
    }

    public void pay(double amount) throws BalanceBelowZeroException, LimitExceededException {
        if (this.limit < amount) {
            throw new LimitExceededException(amount - this.limit);
        }
        if (this.balance - amount < 0) {
            throw new BalanceBelowZeroException(this.balance - amount);
        }
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getLimit() {
        return this.limit;
    }
}