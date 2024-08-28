package com.calculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new OperationFactory());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial value:");
        double initialValue = scanner.nextDouble();

        System.out.println("How many operations do you want to perform?");
        int operationCount = scanner.nextInt();
        Object[] operations = new Object[operationCount * 2];  // To store operations and operands

        for (int i = 0; i < operationCount; i++) {
            System.out.println("Enter operation (ADD, SUBTRACT, MULTIPLY, DIVIDE):");
            String operationInput = scanner.next().toUpperCase();
            Operation operation = Operation.valueOf(operationInput);
            operations[i * 2] = operation;

            System.out.println("Enter next value:");
            double nextValue = scanner.nextDouble();
            operations[i * 2 + 1] = nextValue;
        }

        // Perform chained calculations
        Number result = calculator.chainCalculations(initialValue, operations);
        System.out.println("Final result: " + result);
    }
}