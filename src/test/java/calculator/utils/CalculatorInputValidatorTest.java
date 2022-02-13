package calculator.utils;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorInputValidatorTest {

    @Test
    @DisplayName("null 입력 시 true 반환")
    void inputNull() {
        assertThat(CalculatorInputValidator.isInputNullOrBlankOrEmpty(null)).isTrue();
    }

    @Test
    @DisplayName("아무것도 입력하지 않았을 시 true 반환")
    void inputEmpty() {
        assertThat(CalculatorInputValidator.isInputNullOrBlankOrEmpty("")).isTrue();
    }

    @Test
    @DisplayName("공백 입력 시 true반환")
    void inputBlank() {
        assertThat(CalculatorInputValidator.isInputNullOrBlankOrEmpty(" ")).isTrue();
    }
}