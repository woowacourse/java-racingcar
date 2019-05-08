package junit;

import java.util.function.Function;

public enum ArithmeticOp {

    add {
        int calculate(int value1, int value2) { return value1 + value2;}
    },
    sub {
        int calculate(int value1, int value2) { return value1 - value2;}
    },
    multi {
        int calculate(int value1, int value2) { return value1 * value2;}
    },
    div {
        int calculate(int value1, int value2) { return value1 / value2;}
    };

//    private String sign;
//    private Function<Integer, Integer> expression;

//    ArithmeticOp(Function<Integer,Integer> expression) {this.expression = expression;}

    abstract int calculate(int value1, int value2);
}