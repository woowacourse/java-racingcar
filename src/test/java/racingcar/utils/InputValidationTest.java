package racingcar.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.InvalidTimeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

    @Test
    public void 정상_입력_시() {
        String[] validInput = {"pobi", "brown"};
        InputValidation.validateCars(validInput);   // 정상 처리 시 예외가 발생하지 않음
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "0"})
    public void 시도_횟수가_자연수가_아닌_경우_예외처리(String input) {
        assertThatThrownBy(() -> InputValidation.validateTrials(input))
                .isInstanceOf(InvalidTimeException.class);
    }
}