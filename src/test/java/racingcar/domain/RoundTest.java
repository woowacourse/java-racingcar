package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

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
