package calculator.model;

import java.util.Arrays;

public enum Operator {

    ADD("+") {
        @Override
        public double calculate(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public double calculate(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public double calculate(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    abstract double calculate(double a, double b);

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values()).filter(operator -> operator.matchSymbol(symbol)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자를 입력해주세요. 입력 : " + symbol));
    }

    private boolean matchSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
