package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 100})
    @DisplayName("유효한 round를 생성하는지 검사")
    void valid_round_test(int round) {
        assertDoesNotThrow(() -> Round.fromInput(round));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("유효하지 않는 round를 예외처리하는지 검사")
    void invalid_round_test(int round) {
        assertThatThrownBy(() -> Round.fromInput(round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:2"}, delimiter = ':')
    @DisplayName("다음 자동차 경주 round 정상 반환하는지 검사")
    public void return_valid_next_round(int beforeRoundNumber, int afterRoundNumber) {
        Round round = Round.fromInput(beforeRoundNumber);

        round = round.toNextRound();

        assertThat(round).isEqualTo(Round.fromInput(afterRoundNumber));
    }
}
