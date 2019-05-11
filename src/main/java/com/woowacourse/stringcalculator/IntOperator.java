package com.woowacourse.stringcalculator;

import java.util.function.BinaryOperator;

public enum IntOperator {
    PLUS((i1, i2) -> i1 + i2),
    MINUS((i1, i2) -> i1 - i2),
    MULTIPLY((i1, i2) -> i1 * i2),
    DIVIDE((i1, i2) -> i1 / i2);

    private BinaryOperator<Integer> operation;

    IntOperator(BinaryOperator<Integer> operation) {
        this.operation = operation;
    }

    public static IntOperator valueOf(char operatorChar) {
        if (operatorChar == '+') {
            return PLUS;
        }
        if (operatorChar == '-') {
            return MINUS;
        }
        if (operatorChar == '*') {
            return MULTIPLY;
        }
        if (operatorChar == '/') {
            return DIVIDE;
        }
        throw new IllegalArgumentException("Invalid operator character: " + operatorChar);
    }

    public Integer execute(int x, int y) {
        return operation.apply(x, y);
    }
}
