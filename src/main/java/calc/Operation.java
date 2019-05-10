package calc;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operation {
    ADD("+", (lhs, rhs) -> lhs + rhs),
    SUBTRACT("-", (lhs, rhs) -> lhs - rhs),
    MULTIPLY("*", (lhs, rhs) -> lhs * rhs),
    DIVIDE("/", (lhs, rhs) -> lhs / rhs);

    private String symbol;
    private BiFunction<Double, Double, Double> operation;

    static public Operation ofSymbol(String symbol) throws NoSuchElementException {
        return Stream.of(Operation.values())
                .filter(x -> x.symbol.equals(symbol))
                .findFirst()
                .get();
    }

    Operation(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double apply(double lhs, double rhs) {
        return operation.apply(lhs, rhs);
    }
}