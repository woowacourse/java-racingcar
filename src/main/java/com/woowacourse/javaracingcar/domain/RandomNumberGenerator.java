package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateNumber() {
        return new Random().nextInt(MAX + 1);
    }
}
