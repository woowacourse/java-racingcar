package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesValidatorTest {
    private final CarNamesValidator carNamesValidator = new CarNamesValidator();

    @ParameterizedTest
    @ValueSource(strings = {"prin.mark", "prin;mark"})
    void 지정한_구분자로_구분되어_있지_않을_경우_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> carNamesValidator.validate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지정한_구분자로_구분되어_있을경우_예외가_발생하지_않는다() {
        // given
        String input = "prin,mark";

        // when & then
        assertDoesNotThrow(() -> carNamesValidator.validate(input));
    }

    @Test
    void 지정한_구분자로_구분되어_있지만_마지막이_구분자로_끝날_경우_예외가_발생한다() {
        // given
        String input = "prin,mark,";

        // when & then
        assertThatThrownBy(() -> carNamesValidator.validate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_하나일_경우_예외가_발생하지_않는다() {
        // given
        String input = "prin";

        // when & then
        assertDoesNotThrow(() -> carNamesValidator.validate(input));
    }
}