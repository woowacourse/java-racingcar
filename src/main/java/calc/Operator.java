package calc;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", (lhs, rhs) -> lhs + rhs),
    SUBTRACT("-", (lhs, rhs) -> lhs - rhs),
    MULTIPLY("*", (lhs, rhs) -> lhs * rhs),
    DIVIDE("/", (lhs, rhs) -> lhs / rhs);

    private String symbol;
    private BiFunction<Double, Double, Double> operation;

    static public Operator getOperation(String symbol) {
        try {
            return Stream.of(Operator.values())
                    .filter(x -> x.symbol.equals(symbol))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    Operator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double apply(double lhs, double rhs) {
        return operation.apply(lhs, rhs);
    }
}