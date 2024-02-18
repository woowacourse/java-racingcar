package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Test
    @DisplayName("음수인 경우 예외가 발생한다.")
    void invalidRoundTest() {
        assertThatThrownBy(() -> new Round(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라운드를 줄일 수 있다.")
    void decrease() {
        Round round = new Round(1);
        assertThat(round.isLast()).isFalse();

        round.decrease();
        assertThat(round.isLast()).isTrue();
    }
}
