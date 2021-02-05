package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.Digit;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TimesTest {
    @DisplayName("정상적인 숫자인 경우 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 10000, 20000})
    public void createTimes_정상적인_숫자인_경우(int times) {
        assertThatCode(() -> new Times(times))
                .doesNotThrowAnyException();
    }

    @DisplayName("음수인 경우 예외 발생")
    @Test
    public void createTimes_음수인_경우() {
        final int NEGATIVE_NUMBER = -1;

        assertThatThrownBy(() -> {
            new Times(NEGATIVE_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0인 경우 예외 발생")
    @Test
    public void createTimes_0인_경우() {
        final int ZERO = 0;

        assertThatThrownBy(() -> {
            new Times(ZERO);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한계값을 초과한 경우 예외 발생")
    @Test
    public void createTimes_한계값을_초과한_경우() {
        final int LIMIT_OUT_NUMBER = Digit.TIMES_LIMITATION.getDigit() + 1;

        assertThatThrownBy(() -> {
            new Times(LIMIT_OUT_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}