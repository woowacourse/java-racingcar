package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

class TryCountTest {
    @Test
    @DisplayName("TryCount의 값이 양수면 진행할 수 있어야 한다.")
    void tryCount_successWhenValueIsPositive() {
        // given
        TryCount tryCount = new TryCount(5);

        // expected
        assertThat(tryCount.isAvailable())
                .isTrue();
    }

    @Test
    @DisplayName("TryCount의 값이 0이면 진행할 수 없어야 한다.")
    void tryCount_failWhenValueIsZero() {
        // given
        TryCount tryCount = new TryCount(1);

        // when
        tryCount.tryMove();

        // expected
        assertThat(tryCount.isAvailable())
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("TryCount의 시도 횟수는 음수가 아니어야 한다.")
    @ValueSource(ints = {-1, -2, -3})
    void validate_illegalTryCount(int input) {
        // expected
        assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_TRY_COUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("정상적인 시도 횟수가 검증되어야 한다.")
    @ValueSource(ints = {0, 1, 2, 3, Integer.MAX_VALUE})
    void validate_tryCount(int input) {
        // expected
        assertThatCode(() -> new TryCount(input))
                .doesNotThrowAnyException();
    }
}
