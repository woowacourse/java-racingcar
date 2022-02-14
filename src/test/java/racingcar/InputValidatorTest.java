package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    void 시도횟수_입력_숫자_아닐시_예외() {
        assertThatThrownBy(() ->
            inputValidator.isNumeric("happy")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_입력_자연수_아닐시_예외() {
        assertThatThrownBy(() ->
            inputValidator.isNaturalNumber(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
