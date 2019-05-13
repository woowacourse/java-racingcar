package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RandomNumberGenerator;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomNumberGeneratorTest {

    @Test
    void testGenerateNumber() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        boolean isMaxPresent = false;
        boolean isMinPresent = false;
        for (int i = 0; i < 100; i++) {
            int n = generator.generateNumber(0, 9);
            if (n == 9) {
                isMaxPresent = true;
            }
            if (n == 0) {
                isMinPresent = true;
            }
            assertThat(checkRandomNumberIsValidRange(n)).isTrue();
        }
        assertThat(isMaxPresent).isTrue();
        assertThat(isMinPresent).isTrue();
    }

    private boolean checkRandomNumberIsValidRange(int generateNumber) {
        return 0 <= generateNumber && generateNumber <= 9;
    }
}
