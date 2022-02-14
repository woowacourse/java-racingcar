package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @Test
    @DisplayName("시도 횟수에 빈 값을 넣을 시, 예외가 발생한다.")
    void validEmptyInput() {
        Assertions.assertThatThrownBy(() -> InputValidator.validIterationNo("")).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("빈 값");
    }

    @Test
    @DisplayName("시도 횟수에 문자열 값을 넣을 시, 예외가 발생한다.")
    void validInteger() {
        String input = "문자열";
        Assertions.assertThatThrownBy(() -> InputValidator.validIterationNo(input)).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("입력 받은 값이 올바른 숫자 값이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("시도 횟수에 양수가 아닌 값을 넣었을 때, 예외가 발생한다.")
    void validPositiveInput(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validIterationNo(input)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("양수");
    }
}