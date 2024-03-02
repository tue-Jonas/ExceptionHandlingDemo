package at.htlhl.sew.exceptionhandlingdemo.calculator;

import java.util.Scanner;

public class CalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter first number:");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter second number:");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter an operation (+, -, *, /):");
            String operation = scanner.nextLine();

            double result = calculate(num1, num2, operation);
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format.");
        } catch (ArithmeticException e) {
            System.err.println("Error in arithmetic operation: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Illegal argument: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double calculate(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero.");
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

}