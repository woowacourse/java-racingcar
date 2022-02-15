package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
}