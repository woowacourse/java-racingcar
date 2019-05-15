package textCalculaotr;

public enum Operators implements Calculator{
    PLUS("+") {
        public int result(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        public int result(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        public int result(int x, int y) {
            return x * y;
        }
    },
    DIVISION("/") {
        public int result(int x, int y) {
            return x / y;
        }
    };

    private final String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }
}
