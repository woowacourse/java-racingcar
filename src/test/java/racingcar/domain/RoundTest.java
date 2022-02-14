package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "100"})
    @DisplayName("유효한 round를 생성하는지 검사")
    @Test
    void valid_round_test(String round) {
        assertDoesNotThrow(() -> new Round(round));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("유효하지 않는 round를 예외처리하는지 검사")
    @Test
    void invalid_round_test(String round) {
        assertThatThrownBy(() -> new Round(round))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("남은 자동차 경주 횟수 카운팅 테스트")
    public void round_value_discount(int value) {
        Round round = new Round(value);
        for (int i = 0; i < value; i++) {
            round = round.toNextRound();
        }

        assertThat(round).isEqualTo(new Round(0));
    }
}
