package calc;

import java.util.function.BiFunction;

public enum Operator {
    PLUS((lhs, rhs) -> lhs + rhs),
    MINUS((lhs, rhs) -> lhs - rhs),
    MULTIPLY((lhs, rhs) -> lhs * rhs),
    DIVIDE((lhs, rhs) -> lhs / rhs);

    private BiFunction<Double, Double, Double> func;

    Operator(BiFunction<Double, Double, Double> func) {
        this.func = func;
    }

    static public Operator getFunction(String symbol) {
        final Operator conversionTable[] = { PLUS, MINUS, MULTIPLY, DIVIDE };
        try {
            return conversionTable["+-*/".indexOf(symbol)];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    public double apply(double lhs, double rhs) {
        return func.apply(lhs, rhs);
    }
}