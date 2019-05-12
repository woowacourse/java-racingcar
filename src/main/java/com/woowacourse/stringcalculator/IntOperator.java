package com.woowacourse.stringcalculator;

import java.util.function.BinaryOperator;

public enum IntOperator {
    PLUS('+', (i1, i2) -> i1 + i2),
    MINUS('-', (i1, i2) -> i1 - i2),
    MULTIPLY('*', (i1, i2) -> i1 * i2),
    DIVIDE('/', (i1, i2) -> i1 / i2);

    private char operatorSymbol;
    private BinaryOperator<Integer> operation;

    IntOperator(char symbol, BinaryOperator<Integer> operation) {
        this.operatorSymbol = symbol;
        this.operation = operation;
    }

    public static IntOperator valueOf(char operatorChar) {
        for (IntOperator op : values()) {
            if (operatorChar == op.operatorSymbol) {
                return op;
            }
        }

        throw new IllegalArgumentException("Invalid operator character: " + operatorChar);
    }

    public Integer execute(int x, int y) {
        return operation.apply(x, y);
    }
}
