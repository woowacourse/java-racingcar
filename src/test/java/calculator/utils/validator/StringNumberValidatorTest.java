package calculator.utils.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringNumberValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 값이 입력된 경우")
    void inputNotNumber() {
        assertThatThrownBy(() -> StringNumberValidator.validate("a"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("빈 문자열이 입력된 경우")
    void inputEmptyString() {
        assertThatThrownBy(() -> StringNumberValidator.validate(""))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 입력된 경우")
    void inputNegativeNumber() {
        assertThatThrownBy(() -> StringNumberValidator.validate("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("실수가 입력된 경우")
    void inputDouble() {
        assertThatThrownBy(() -> StringNumberValidator.validate("0.01"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("정상적인 숫자를 입력한 경우")
    void inputValidNumber() {
        assertThat(StringNumberValidator.validate("1")).isTrue();
    }

}