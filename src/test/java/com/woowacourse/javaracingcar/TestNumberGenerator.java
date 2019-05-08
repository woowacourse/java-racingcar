package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private int[] numbers;
    private int index;

    public TestNumberGenerator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generateNumber() {
        return numbers[index++];
    }
}
