package cal.domain;

public enum Operator {
    ADD('+') {
        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS('-') {
        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLE('*') {
        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        @Override
        public int calculate(int num1, int num2) {
            divideOperandZeroException(num2);
            return num1 / num2;
        }
    };

    private char operator;

    private Operator(char operator) {
        this.operator = operator;
    }

    public abstract int calculate(int num1, int num2);

    protected void divideOperandZeroException(double num) {
        if (num == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }
}
