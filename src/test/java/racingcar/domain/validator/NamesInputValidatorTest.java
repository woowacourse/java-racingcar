package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException;

public class NamesInputValidatorTest {

    private NamesInputValidator namesInputValidator;

    @BeforeEach
    public void setUp() {
        namesInputValidator = new NamesInputValidator();
    }

    @Test
    public void 입력값이_null일_경우_예외_발생() {
        assertThatThrownBy(() -> namesInputValidator.validate(null))
                .isInstanceOf(CarNameException.class).hasMessage(NamesInputValidator.NULL_INPUT_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_6글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> namesInputValidator.validate("pobiisawesome,jason,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesInputValidator.INVALID_LENGTH_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_공백일_경우_예외_발생() {
        assertThatThrownBy(() -> namesInputValidator.validate("pobi,,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesInputValidator.EMPTY_NAME_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_중복일_경우_예외_발생() {
        assertThatThrownBy(() -> namesInputValidator.validate("pobi,pobi,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesInputValidator.DUPLICATE_NAME_ERROR_MESSAGE);
    }
}
