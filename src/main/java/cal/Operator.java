package cal;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Math::addExact),
    MINUS("-", Math::subtractExact),
    MULTIPLY("*", Math::multiplyExact),
    DIVIDE("/", (x, y) -> x / y),
    EMPTY(" ", (x, y) -> null);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getSymbol().equals(symbol))
                .findAny()
                .orElse(EMPTY);
    }

    public String getSymbol() {
        return symbol;
    }

    public int calculator(int x, int y) {
        return expression.apply(x, y);
    }
}
