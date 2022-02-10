package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    public void 정수가_아닌_값_검증() {
        assertThatThrownBy(() -> {
            InputValidator.validateInteger("일");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 빈_이름_검증() {
        assertThatThrownBy(() -> {
            InputValidator.validateName("");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 길이_검증() {
        assertThatThrownBy(() -> {
            InputValidator.validateName("abcdef");
        }).isInstanceOf(RuntimeException.class);
    }
}
