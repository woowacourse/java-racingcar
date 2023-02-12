package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

class TryCountTest {

    @Test
    @DisplayName("TryCount의 값은 음수가 아니어야 한다.")
    void tryCount_negativeValue() {
        // expected
        assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_TRY_COUNT.getMessage());
    }

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
}
