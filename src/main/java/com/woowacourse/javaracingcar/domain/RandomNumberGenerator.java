package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
