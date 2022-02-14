package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @Test
    @DisplayName("null 입력 시 true 반환")
    void inputNull() {
        assertThat(InputValidator.isInputNullOrBlankOrEmpty(null)).isTrue();
    }

    @Test
    @DisplayName("아무것도 입력하지 않았을 시 true 반환")
    void inputEmpty() {
        assertThat(InputValidator.isInputNullOrBlankOrEmpty("")).isTrue();
    }

    @Test
    @DisplayName("공백 입력 시 true 반환")
    void inputBlank() {
        assertThat(InputValidator.isInputNullOrBlankOrEmpty(" ")).isTrue();
    }
}