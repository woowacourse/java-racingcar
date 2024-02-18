package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundTest {

    @Test
    @DisplayName("음수인 경우 예외가 발생한다.")
    void invalidRoundTest() {
        assertThrows(IllegalArgumentException.class, () -> new Round(-1));
    }
}
