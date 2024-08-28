package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(new OperationFactory());
    }

    @Test
    void testAddOperation() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    void testSubtractOperation() {
        assertEquals(1.0, calculator.calculate(Operation.SUBTRACT, 5, 4));
    }

    @Test
    void testMultiplyOperation() {
        assertEquals(20.0, calculator.calculate(Operation.MULTIPLY, 5, 4));
    }

    @Test
    void testDivideOperation() {
        assertEquals(5.0, calculator.calculate(Operation.DIVIDE, 10, 2));
    }

    @Test
    void testChainCalculations() {
        assertEquals(16.0, calculator.chainCalculations(5, Operation.ADD, 3, Operation.MULTIPLY, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(Operation.DIVIDE, 10, 0));
    }
}