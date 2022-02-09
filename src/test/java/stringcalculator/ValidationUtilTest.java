package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
    void ValidString() {
        String[] numbers = new String[]{"0", "1", "2"};

        assertThatCode(() -> ValidationUtil.checkNumber(numbers))
                .doesNotThrowAnyException();
    }
}
