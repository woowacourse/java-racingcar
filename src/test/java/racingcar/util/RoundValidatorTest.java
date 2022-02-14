package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoundValidatorTest {

    @Test
    void checkPositive() {
        assertThatThrownBy(() -> {
            RoundValidator.checkPositive(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}