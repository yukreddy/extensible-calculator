# Flexible Calculator

## Description
This is a flexible and extensible calculator built in Java. It supports basic operations such as addition, subtraction, multiplication, and division. The calculator is designed to be easily extendable for future operations, following core software design principles like the Open-Closed Principle (OCP) and Inversion of Control (IoC).

## How to Run

1. **Clone the Repository**:
   - Open a terminal and run the following command to clone the repository:
     ```
     https://github.com/yukreddy/extensible-calculator/
     ```
   - Navigate into the project directory:
     ```
     cd extensible-calculator
     ```

2. **Build the Project** (using Maven):
   - In the project directory, run:
     ```
     mvn clean install
     ```

3. **Run the Unit Tests**:
   - To execute the tests, run:
     ```
     mvn test
     ```

4. **Run the Application**:
   - You can run the `CalculatorApp` class to manually input values and perform operations. Here's an example interaction:

     ```
     Enter initial value:
     5
     How many operations do you want to perform?
     2
     Enter operation (ADD, SUBTRACT, MULTIPLY, DIVIDE):
     ADD
     Enter next value:
     3
     Enter operation (ADD, SUBTRACT, MULTIPLY, DIVIDE):
     MULTIPLY
     Enter next value:
     2
     Final result: 16.0
     ```

## Design Decisions
- **Extensibility with Strategy Pattern**: Each operation (e.g., ADD, SUBTRACT) is implemented as a separate class using the Strategy Pattern. This allows adding new operations without modifying existing code, following the Open-Closed Principle.

- **Inversion of Control (IoC) Compatibility**: The `OperationFactory` handles injecting operations into the `Calculator`, decoupling the `Calculator` from specific implementations, ensuring compatibility with IoC frameworks.

- **Single Responsibility Principle**: Each class has a distinct responsibility. For example, the `AddOperation` class handles only addition, while the `OperationFactory` handles registering and providing operations.

- **Error Handling**: Exceptions are properly handled for invalid operations and division by zero to ensure robustness.

## Assumptions
- **Basic Operations**: The calculator performs basic arithmetic operations (ADD, SUBTRACT, MULTIPLY, DIVIDE). Only these operations are assumed to be required initially, but the design supports adding more.

- **Chained Calculations**: The calculator supports chaining operations in sequence, starting with an initial value and applying operations step by step.

- **Input as Number Type**: The input is expected to be of the `Number` type (e.g., integers, doubles). We use `doubleValue()` for all operations to ensure uniformity, which may impact precision for very large numbers.