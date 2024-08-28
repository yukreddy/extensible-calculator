package com.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<Operation, OperationHandler> operationHandlers = new HashMap<>();

    public Calculator(OperationFactory factory) {
        factory.registerOperations(operationHandlers);
    }

    public Number calculate(Operation operation, Number num1, Number num2) {
        if (!operationHandlers.containsKey(operation)) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        return operationHandlers.get(operation).apply(num1, num2);
    }

    public Number chainCalculations(Number initialValue, Object... operations) {
        Number result = initialValue;
        for (int i = 0; i < operations.length; i += 2) {
            Operation op = (Operation) operations[i];
            Number nextValue = (Number) operations[i + 1];
            result = calculate(op, result, nextValue);
        }
        return result;
    }
}