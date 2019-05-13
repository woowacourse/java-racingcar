package stringcalc;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    SUBTRACT("-") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MULTIPLY("*") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVISION("/") {
        @Override
        int calculate(int firstOperand, int secondOperand) {
            return firstOperand / secondOperand;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator stringToOperator(String inputOperator) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getOperator().equals(inputOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자 입력 오류"));
    }

    abstract int calculate(int firstOperand, int secondOperand);
}
