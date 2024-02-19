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
    @DisplayName("진행할 라운드가 더 남아있는지 여부를 알 수 있다.")
    void decrease() {
        Round round = new Round(1);
        assertThat(round.isPlayable()).isTrue();

        round.decrease();
        assertThat(round.isPlayable()).isFalse();
    }
}
