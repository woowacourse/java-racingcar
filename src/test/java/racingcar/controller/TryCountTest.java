package racingcar.controller;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @Test
    @DisplayName("시도 횟수가 다되면 거짓이 반환되어야 한다.")
    void tryCount_countdownCompleteReturnFalse() {
        // given
        TryCount tryCount = new TryCount(5);

        // when
        while (tryCount.isRemaining()) {
            tryCount.countdown();
        }

        // then
        assertThat(tryCount.isRemaining())
                .isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 남으면 참이 반환되어야 한다.")
    void tryCount_countdownNotCompleteReturnTrue() {
        // given
        TryCount tryCount = new TryCount(5);

        // expect
        assertThat(tryCount.isRemaining())
                .isTrue();
    }

    @Test
    @DisplayName("시도 횟수에 음수가 주어지면 예외가 발생해야 한다.")
    void create_minusInput() {
        // expect
        assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_TRY_COUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 정상적으로 생성되어야 한다.")
    @ValueSource(ints = {0, 1, 2, Integer.MAX_VALUE})
    void create_success(int input) {
        // expect
        assertThatCode(() -> new TryCount(input))
                .doesNotThrowAnyException();
    }
}
