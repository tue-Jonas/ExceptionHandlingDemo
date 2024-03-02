package at.htlhl.sew.exceptionhandlingdemo.creditcard;

import java.util.Scanner;

public class CreditCardExample {

    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1000, 500);
        Scanner scanner = new Scanner(System.in);

        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Error: Invalid input. Please enter a number.");
            }
        });

        while (creditCard.getBalance() > 0) {
            System.out.println("Enter the amount to charge:");
            double amount = scanner.nextDouble();

            try {
                creditCard.pay(amount);
                System.out.println("Payment successful. Remaining balance: " + creditCard.getBalance());
            } catch (BalanceBelowZeroException e) {
                System.out.println("Error: Balance would go below zero by " + e.getExceededAmount());
            } catch (LimitExceededException e) {
                System.out.println("Error: Payment would exceed limit by " + e.getExceededAmount());
            }
        }
    }

}