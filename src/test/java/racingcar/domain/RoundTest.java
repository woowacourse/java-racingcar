package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"!", "-1", "abc"})
    @DisplayName("숫자가 아니거나, 음수인 경우 예외가 발생한다.")
    void invalidRoundTest(final String input) {
        assertThrows(IllegalArgumentException.class, () -> new Round(input));
    }
}
