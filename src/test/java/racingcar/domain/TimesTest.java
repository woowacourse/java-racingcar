package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TimesTest {
    @DisplayName("정상적인 숫자인 경우 Times 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 10000, 20000})
    public void createTimes(int times) {
        assertThatCode(() -> new Times(times))
                .doesNotThrowAnyException();
    }

    @DisplayName("음수인 경우 예외를 발생시킨다")
    @Test
    public void createTimesNegativeException() {
        final int NEGATIVE_NUMBER = -1;

        assertThatThrownBy(() -> {
            new Times(NEGATIVE_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0인 경우 예외를 발생시킨다")
    @Test
    public void createTimesZeroException() {
        final int ZERO = 0;

        assertThatThrownBy(() -> {
            new Times(ZERO);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한계값을 초과한 경우 예외를 발생시킨다")
    @Test
    public void createTimesLimitationException() {
        final int TIMES_LIMITATION = (int) 1e8;
        final int LIMIT_OUT_NUMBER = TIMES_LIMITATION + 1;

        assertThatThrownBy(() -> {
            new Times(LIMIT_OUT_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
