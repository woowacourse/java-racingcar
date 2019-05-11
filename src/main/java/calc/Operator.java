package calc;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (lhs, rhs) -> lhs + rhs),
    MINUS("-", (lhs, rhs) -> lhs - rhs),
    MULTIPLY("*", (lhs, rhs) -> lhs * rhs),
    DIVIDE("/", (lhs, rhs) -> lhs / rhs);

    private String symbol;
    private BiFunction<Double, Double, Double> func;

    private Operator(String symbol, BiFunction<Double, Double, Double> func) {
        this.symbol = symbol;
        this.func = func;
    }

    public double calculate(double lhs, double rhs) {
        return func.apply(lhs, rhs);
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
