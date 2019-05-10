package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

enum Operator implements IntBinaryOperator {

    PLUS("+", Integer::sum),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private final String symbol;
    private final IntBinaryOperator binaryOperator;

    Operator(String symbol, IntBinaryOperator intBinaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = intBinaryOperator;
    }

    @Override
    public int applyAsInt(int left, int right) {
        return binaryOperator.applyAsInt(left, right);
    }

    public static boolean isOperator(String symbol) {
        return Arrays.stream(values())
                .map(operator -> operator.symbol)
                .anyMatch(collectSymbol -> collectSymbol.equals(symbol));
    }

    public static Operator findOperator(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("해당 연산기호가 없습니다.");
    }

}
