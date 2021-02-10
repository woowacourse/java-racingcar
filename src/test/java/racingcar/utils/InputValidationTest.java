package racingcar.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "0"})
    public void 시도_횟수가_자연수가_아닌_경우_예외처리(String input) {
        assertThatThrownBy(() -> InputValidation.validateTime(input))
                .isInstanceOf(InvalidTimeException.class);
    }
}