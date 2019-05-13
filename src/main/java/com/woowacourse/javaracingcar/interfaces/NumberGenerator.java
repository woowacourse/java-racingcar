package com.woowacourse.javaracingcar.interfaces;

public interface NumberGenerator {
    /**
     *
     * @param min Minimum value of number will be generated.
     * @param max Maximum value of number will be generated.
     * @return Generated number x: min <= x <= max
     */
    int generateNumber(int min, int max);
}
