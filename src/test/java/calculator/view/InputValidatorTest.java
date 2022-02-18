package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("계산기에 null 입력 시 true 반환")
    void inputNull() {
        assertThat(InputValidator.isInputNullOrBlankOrEmpty(null)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("계산기에 아무것도 입력하지 않았을 시 true 반환")
    void inputEmpty(String input) {
        assertThat(InputValidator.isInputNullOrBlankOrEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자 이외의 값 입력시 예외")
    @ValueSource(strings = {"-1,2,3", "a,2,3"})
    void inputNegativeNumberException(String input) {
        assertThatThrownBy(() -> InputValidator.checkValidateNumbers(List.of(input.split(""))))
                .isInstanceOf(RuntimeException.class);
    }
}