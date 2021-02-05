package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.utils.exception.InvalidTextException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    final InputValidation inputValidation = new InputValidation();

    @Test
    public void 문자_외의_입력_시_예외처리() {
        String[] input = {"pobi#", "brown"};
        assertThatThrownBy(() -> inputValidation.validateName(input))
        .isInstanceOf(InvalidTextException.class);
    }
}