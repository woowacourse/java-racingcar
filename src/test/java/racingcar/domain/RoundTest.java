package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {
    @DisplayName("Test for valid round")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void checkIsValidRound(int inputNumber) {
        assertThatThrownBy(() -> Round.create(inputNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
