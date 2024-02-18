package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {


    @DisplayName("음수 입력 시 예외")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10})
    void invalidInput(int value) {
        assertThatThrownBy(() -> new Round(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("진행중인 라운드 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    void isContinueTrue(int source) {
        // given when
        Round round = new Round(source);

        // then
        assertThat(round.isContinue()).isTrue();
    }

    @DisplayName("라운드 종료 확인")
    @Test
    void isContinueFalse() {
        // given when
        Round round = new Round(0);

        // then
        assertThat(round.isContinue()).isFalse();
    }

    @DisplayName("라운드 실행시 값이 1 감소한다.")
    @Test
    void progress() {
        // given
        Round round = new Round(2);

        // when
        round.progress();

        // then
        assertThat(round).extracting("value").isEqualTo(1);
    }

    @DisplayName("라운드가 0이면 진행할 때 예외이다.")
    @Test
    void zeroProgress() {// given
        Round round = new Round(0);

        assertThatThrownBy(round::progress)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 진행할 라운드가 없습니다.");
    }
}
