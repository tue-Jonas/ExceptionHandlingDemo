package at.htlhl.sew.exceptionhandlingdemo.creditcard;

public class LimitExceededException extends Exception {
    private final double exceededAmount;

    public LimitExceededException(double exceededAmount) {
        this.exceededAmount = exceededAmount;
    }

    public double getExceededAmount() {
        return exceededAmount;
    }
}