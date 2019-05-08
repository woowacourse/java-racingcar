package calculator;

public enum ArithmeticOp {

    ADD {
        int calculate(int value1, int value2) { return value1 + value2;}
    },
    SUB {
        int calculate(int value1, int value2) { return value1 - value2;}
    },
    MULTI {
        int calculate(int value1, int value2) { return value1 * value2;}
    },
    DIV {
        int calculate(int value1, int value2) { return value1 / value2;}
    };

//    private Function<Integer, Integer> expression;
//    ArithmeticOp(Function<Integer,Integer> expression) {this.expression = expression;}

    abstract int calculate(int value1, int value2);
}