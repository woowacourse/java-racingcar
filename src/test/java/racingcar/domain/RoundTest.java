package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.Round.INVALID_NUMBER_OF_ROUNDS_MESSAGE;
import static racingcar.domain.Round.NOT_INTEGER_ERROR_MESSAGE;

class RoundTest {
    @DisplayName("정수가 아닌 라운드 횟수가 주어졌을 때 제대로 검증 하는지")
    @ParameterizedTest
    @ValueSource(strings = {"나정수아니야", "1.5"})
    void roundConstructor_nonIntegerRound_throwIllegalArgumentException(String numberOfRounds) {
        assertThatThrownBy(() -> new Round(numberOfRounds)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INTEGER_ERROR_MESSAGE);
    }

    @DisplayName("음수인 라운드 횟수가 주어졌을 때 제대로 검증 하는지")
    @Test
    void roundConstructor_negativeRound_throwIllegalArgumentException() {
        assertThatThrownBy(() -> new Round("-5")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_OF_ROUNDS_MESSAGE);
    }
}