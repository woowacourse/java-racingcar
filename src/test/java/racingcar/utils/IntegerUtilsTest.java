package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerUtilsTest {

    @DisplayName("숫자인 문자열을 정상적으로 parseInt하는지 확인")
    @Test
    void Should_SuccessToPositiveNumber() {
        String input = "2";
        Assertions.assertThat(IntegerUtils.parseInt(input)).isEqualTo(2);
    }

    @DisplayName("숫자가 아닌 문자열 parseInt할 경우 예외 발생")
    @Test
    void Should_FailToString() {
        String input = "hello";
        assertThatThrownBy(() -> IntegerUtils.parseInt(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상의 양수");
    }
}
