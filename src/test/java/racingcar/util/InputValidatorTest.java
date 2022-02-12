package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    public void 정수가_아닌_값_검증() {
        assertThatThrownBy(() -> {
            InputValidator.validateTryCount("일");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 이름_공백_검증() {
        assertThatThrownBy(() -> {
            InputValidator.validateName("");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 이름_길이_검증() {
        assertThatThrownBy(() -> {
            InputValidator.validateName("abcdef");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 음수인_숫자_입력() {
        String scanNumber = "-3";
        assertThatThrownBy(() -> {
            InputValidator.validateNegativeTryCount(-3);
        }).isInstanceOf(RuntimeException.class);
    }
}
