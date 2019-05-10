package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

enum Operator implements IntBinaryOperator {

    PLUS("+", (left, right) -> left + right),
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
        List<String> operatorSet = new ArrayList<>();

        for (Operator operator : values()) {
            operatorSet.add(operator.symbol);
        }
        return operatorSet.contains(symbol);
    }

    public static Operator valueof(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("해당 연산기호가 없습니다.");
    }

}
