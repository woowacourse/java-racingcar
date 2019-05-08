package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    void testGenerateNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        for (int i = 0; i < 100; i++) {
            assertThat(checkRandomNumberIsValidRange(generator.generateNumber())).isTrue();
        }
    }

    private boolean checkRandomNumberIsValidRange(int generateNumber) {
        return NumberGenerator.MIN <= generateNumber && generateNumber <= NumberGenerator.MAX;
    }
}
