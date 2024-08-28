package com.calculator;

public class MultiplyOperation implements OperationHandler {
    @Override
    public Number apply(Number num1, Number num2) {
        return num1.doubleValue() * num2.doubleValue();
    }
}