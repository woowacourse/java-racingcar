package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("다음 라운드를 반환할 수 있다.")
    void nextRound() {
        final Round round = new Round(2);
        final Round expected = new Round(3);
        assertThat(round.nextRound()).isEqualTo(expected);
    }

    @Test
    @DisplayName("equals hashCode 재정의를 통해 값을 비교할 수 있다.")
    void equalsHashCodeRedefinition() {
        final Round round = new Round(1);
        final Round expected = new Round(1);
        assertThat(round).isEqualTo(expected);
    }
}