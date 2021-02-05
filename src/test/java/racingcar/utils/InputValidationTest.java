package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.utils.exception.DuplicateNameException;
import racingcar.utils.exception.InvalidNameLengthException;
import racingcar.utils.exception.InvalidTextException;
import racingcar.utils.exception.NotEnoughCarException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {
    final InputValidation inputValidation = new InputValidation();

    @Test
    public void 정상_입력_시() {
        String[] validInput = {"pobi", "brown"};
        inputValidation.validateName(validInput);   // 정상 처리 시 예외가 발생하지 않음
    }

    @Test
    public void 문자_외의_입력_시_예외처리() {
        String[] invalidInput = {"pobi#", "brown"};
        assertThatThrownBy(() -> inputValidation.validateName(invalidInput))
        .isInstanceOf(InvalidTextException.class);
    }

    @Test
    public void 이름_길이가_잘못된_경우_예외처리() {
        String[] overLength = {"poooobi", "brown"};
        assertThatThrownBy(() -> inputValidation.validateName(overLength))
                .isInstanceOf(InvalidNameLengthException.class);

        String[] lessLength = {"pobi", ""};
        assertThatThrownBy(() -> inputValidation.validateName(overLength))
                .isInstanceOf(InvalidNameLengthException.class);
    }

    @Test
    public void 이름이_중복되는_경우_예외처리() {
        String[] duplicateInput = {"pobi", "brown", "pobi"};
        assertThatThrownBy(() -> inputValidation.validateName(duplicateInput))
                .isInstanceOf(DuplicateNameException.class);
    }

    @Test
    public void 자동차가_1대인_경우_예외처리() {
        String[] input = {"pobi"};
        assertThatThrownBy(() -> inputValidation.validateName(input))
                .isInstanceOf(NotEnoughCarException.class);
    }
}