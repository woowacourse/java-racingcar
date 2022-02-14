package racingcar.domain.round;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @DisplayName("라운드가 양수일 경우 정상적으로 생성되는지 확인")
    @Test
    void roundWithPositiveNumber() {
        Round round = new Round("3");
        Assertions.assertThat(round.isSame(3)).isTrue();
    }

    @DisplayName("라운드가 음수일 경우 예외 발생")
    @Test
    void roundWithNegativeNumber() {
        String input = "-1";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round(input))
            .withMessageContaining("1 이상의 양수");
    }

    @DisplayName("라운드가 0일 경우 예외 발생")
    @Test
    void roundWithZero() {
        String input = "0";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round(input))
            .withMessageContaining("1 이상의 양수");
    }

    @DisplayName("라운드가 숫자가 아닐 경우 예외 발생")
    @Test
    void roundWithNotNumericValue() {
        String input = "hello";
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Round(input))
            .withMessageContaining("1 이상의 양수");
    }
}
