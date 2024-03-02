package at.htlhl.sew.exceptionhandlingdemo.creditcard;

public class BalanceBelowZeroException extends Exception {
    private final double exceededAmount;

    public BalanceBelowZeroException(double exceededAmount) {
        this.exceededAmount = exceededAmount;
    }

    public double getExceededAmount() {
        return exceededAmount;
    }
}
