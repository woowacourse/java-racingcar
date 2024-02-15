package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator() {
        @Override
        void validateCustom(String input) {
            // do nothing
        }
    };

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\n"})
    void 입력값이_비어있을_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> inputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi ", " pobi", " pobi ", "pobi, woni", "pobi, woni, ", " pobi, woni, jun"})
    void 입력값에_공백이_포함되어_있을_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> inputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,woni", "pobi,woni,jun"})
    void 입력값이_비어있지_않거나_공백이_없을_경우_예외가_발생하지_않는다(String input) {
        // when & then
        assertDoesNotThrow(() -> inputValidator.validate(input));
    }
}
