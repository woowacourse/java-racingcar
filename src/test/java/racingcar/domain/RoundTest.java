package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    @DisplayName("시도 횟수 카운팅 감소 기능")
    public void round_value_discount(int value) {
        Round round = Round.fromNumber(value);
        for (int i = 1; i < value; i++) {
            round = round.reduce();
        }

        assertThat(round).isEqualTo(Round.fromNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("시도 횟수 객체 생성시 0이하는 예외처리 기능")
    public void round_value_inValid(int value) {
        assertThatThrownBy(() -> Round.fromNumber(value))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
