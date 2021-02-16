package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TimesTest {
    @DisplayName("정상적인 숫자인 경우 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 100, 10000, 20000})
    public void createTimes_정상적인_숫자인_경우(final int times) {
        assertThatCode(() -> new Times(times))
                .doesNotThrowAnyException();
    }

    @DisplayName("음수인 경우 예외 발생")
    @Test
    public void createTimes_음수인_경우() {
        final int negativeNumber = -1;

        assertThatThrownBy(() -> {
            new Times(negativeNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한계값을 초과한 경우 예외 발생")
    @Test
    public void createTimes_한계값을_초과한_경우() {
        assertThatThrownBy(() -> {
            new Times(Times.LIMITATION + 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
