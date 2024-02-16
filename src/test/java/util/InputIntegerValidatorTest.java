package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class InputIntegerValidatorTest {
    private final InputValidator inputIntegerValidator = new InputIntegerValidator();

    @Test
    void 숫자가_아닐_경우_예외가_발생한다() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> inputIntegerValidator.validate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자일_경우_예외가_발생하지_않는다() {
        // given
        String input = "1";

        // when & then
        assertDoesNotThrow(() -> inputIntegerValidator.validate(input));
    }
}
