package calc;

import java.util.function.BiFunction;

public enum Operator {
    ADD((lhs, rhs) -> lhs + rhs),
    SUBTRACT((lhs, rhs) -> lhs - rhs),
    MULTIPLY((lhs, rhs) -> lhs * rhs),
    DIVIDE((lhs, rhs) -> lhs / rhs);

    private BiFunction<Double, Double, Double> operation;

    static public Operator getOperation(String symbol) {
        final Operator conversionTable[] = { ADD, SUBTRACT, MULTIPLY, DIVIDE };
        try {
            return conversionTable["+-*/".indexOf(symbol)];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    Operator(BiFunction<Double, Double, Double> operation) {
        this.operation = operation;
    }

    public double apply(double lhs, double rhs) {
        return operation.apply(lhs, rhs);
    }
}