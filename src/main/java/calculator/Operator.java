package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

enum Operator implements DoubleBinaryOperator {

    PLUS("+", (l, r) -> l + r),
    MINUS("-", (l, r) -> l - r),
    MULTIPLY("*", (l, r) -> l * r),
    DIVIDE("/", (l, r) -> l / r);

    private final String symbol;
    private final DoubleBinaryOperator binaryOperator;

    Operator(String symbol, DoubleBinaryOperator doubleBinaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = doubleBinaryOperator;
    }

    @Override
    public double applyAsDouble(double left, double right) {
        return binaryOperator.applyAsDouble(left, right);
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
