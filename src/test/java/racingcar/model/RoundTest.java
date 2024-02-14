package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {


    @DisplayName("유효하지 않은 입력 시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1"})
    void invalidInput(String value) {
        // given
        // when
        // then
        assertThatThrownBy(() -> Round.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("진행중인 라운드 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "100"})
    void isEndFalse(String source) {
        // given
        // when
        Round round = Round.from(source);
        // then
        assertThat(round.isEnd()).isFalse();
    }

    @DisplayName("라운드 종료 확인")
    @Test
    void isEndTrue() {
        // given
        // when
        Round round = Round.from("0");

        // then
        assertThat(round.isEnd()).isTrue();
    }

    @DisplayName("라운드 실행시 값이 1 감소한다.")
    @Test
    void progress() {
        // given
        Round round = Round.from("2");

        // when
        round.progress();

        // then
        assertThat(round).extracting("value").isEqualTo(1);
    }
}