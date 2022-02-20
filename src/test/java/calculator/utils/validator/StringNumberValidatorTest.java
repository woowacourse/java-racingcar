package calculator.utils.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "", "-1", "0.01"})
    @DisplayName("잘못된 값 입력")
    void invalidInput() {
        assertThatThrownBy(() -> StringNumberValidator.validate("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정상적인 숫자를 입력한 경우")
    void inputValidNumber() {
        assertThat(StringNumberValidator.validate("1")).isTrue();
    }
}