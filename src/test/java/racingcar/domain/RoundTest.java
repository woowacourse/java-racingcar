package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    @DisplayName("라운드가 0이하의 값으로 생성하려고 하는 경우 예외가 발생한다.")
    void createExceptionNegativeRound(final int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round(input))
            .withMessageMatching("라운드는 0이하의 값이 들어올 수 없다.");
    }
}