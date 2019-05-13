package stringcalc;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int firstOperand, int secondOperand) {
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

    private Operator(String operator) {
        this.operator = operator;
    }

    private String getOperator() {
        return operator;
    }

    public static Operator stringToOperator(String inputOperator) {
        for (Operator operator : Operator.values()) {
            if (operator.getOperator().equals(inputOperator)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다.");
    }

    abstract int calculate(int firstOperand, int secondOperand);
}
