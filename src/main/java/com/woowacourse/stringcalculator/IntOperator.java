package com.woowacourse.stringcalculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

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
        try {
            return Arrays.stream(values()).filter(op -> op.operatorSymbol == operatorChar)
                .collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException e) { // 인자와 일치하는 객체가 없다 === 유효하지 않은 인자
            throw new IllegalArgumentException("Invalid operator character: " + operatorChar);
        }
    }

    public Integer execute(int x, int y) {
        return operation.apply(x, y);
    }
}
