package calculator.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> method;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> method) {
        this.symbol = symbol;
        this.method = method;
    }

    public static Operator from(final String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int a, int b) {
        return this.method.apply(a, b);
    }
}
