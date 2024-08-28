package com.calculator;

import java.util.Map;

public class OperationFactory {

    public void registerOperations(Map<Operation, OperationHandler> operationHandlers) {
        operationHandlers.put(Operation.ADD, new AddOperation());
        operationHandlers.put(Operation.SUBTRACT, new SubtractOperation());
        operationHandlers.put(Operation.MULTIPLY, new MultiplyOperation());
        operationHandlers.put(Operation.DIVIDE, new DivideOperation());
    }
}