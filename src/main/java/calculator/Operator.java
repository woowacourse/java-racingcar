package calculator;

public enum Operator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String symbol;

    Operator(String type) {
        this.symbol = type;
    }

    public static Operator getOperatorBy(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("일치하는 연산 기호가 없습니다.");
    }

    public int calculate(int leftValue, int rightValue) {
        if (isSameSymbol(ADD)) {
            return (leftValue + rightValue);
        }
        if (isSameSymbol(SUB)) {
            return (leftValue - rightValue);
        }
        if (isSameSymbol(MUL)) {
            return (leftValue * rightValue);
        }
        if (isSameSymbol(DIV)) {
            if (rightValue == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return (leftValue / rightValue);
        }

        throw new IllegalArgumentException("잘못된 operator 를 입력하셨습니다.");
    }

    private boolean isSameSymbol(Operator operator) {
        return (this.symbol.equals(operator.symbol));
    }
}
