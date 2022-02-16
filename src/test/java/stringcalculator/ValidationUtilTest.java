package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilTest {

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우")
    void invalidString() {
        String[] notNumber = new String[]{"a", "1", "2"};

        assertThatThrownBy(() -> ValidationUtil.checkNumber(notNumber))
                .isInstanceOf(RuntimeException.class).hasMessage("숫자가 아닙니다!");
    }

    @Test
    @DisplayName("입력값이 숫자인 경우")
    void validString() {
        String[] numbers = new String[]{"0", "1", "2"};

        assertThatCode(() -> ValidationUtil.checkNumber(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 음수인 경우 예외 발생")
    void negativeInput() {
        String[] numbers = new String[]{"-1", "2"};

        assertThatThrownBy(() -> ValidationUtil.checkPositive(numbers))
                .isInstanceOf(RuntimeException.class).hasMessage("음수가 포함돼있습니다!");
    }
}
