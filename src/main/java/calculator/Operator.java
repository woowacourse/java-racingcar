package calculator;

public enum Operator {
    PLUS {
        int calculate(int result, int next) {return result + next;}
    },
    MINUS {
        int calculate(int result, int next) {return result - next;}
    },
    DIVIDE {
        int calculate(int result, int next) {return result / next;}
    },
    MULTIPLY {
        int calculate(int result, int next) {return result * next;}
    };

    abstract int calculate(int result, int next);
}
