package cal;

import java.util.Arrays;

public enum Operator {
    PLUS('+') {
        @Override
        int calculate(int num1, int num2) {
            return num1 + num2;
        }
    }, //더하기
    MINUS('-') {
        @Override
        int calculate(int num1, int num2) {
            return num1 - num2;
        }
    }, //빼기
    MULTIPLE('*') {
        @Override
        int calculate(int num1, int num2) {
            return num1 * num2;
        }
    }, //곱하기
    DIVIDE('/') {
        @Override
        int calculate(int num1, int num2) throws IllegalArgumentException {
            if (num2 == 0) {
                throw new IllegalArgumentException("0으로 나누면 안됩니다.");
            }
            return num1 / num2;
        }
    }; //나누기

    private char operator;

    Operator(char operator) {
        this.operator = operator;
    }

    abstract int calculate(int num1, int num2);


    public static Operator fromName(char operator) {
        return Arrays.stream(Operator.values()).filter(o -> o.getOperator() == operator).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isOperator(char operator) {
        return Arrays.stream(Operator.values()).anyMatch(o -> o.isMatch(operator));
    }

    public char getOperator() {
        return operator;
    }

    private boolean isMatch(char operator) {
        return this.operator == operator;
    }
}
