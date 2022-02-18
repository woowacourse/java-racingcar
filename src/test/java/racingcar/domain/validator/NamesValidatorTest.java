package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException;

public class NamesValidatorTest {

    private NamesValidator namesValidator;

    @BeforeEach
    public void setUp() {
        namesValidator = new NamesValidator();
    }

    @Test
    public void 입력값이_null일_경우_예외_발생() {
        assertThatThrownBy(() -> namesValidator.validate(null))
                .isInstanceOf(CarNameException.class).hasMessage(NamesValidator.NULL_INPUT_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_6글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> namesValidator.validate("pobiisawesome,jason,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesValidator.INVALID_LENGTH_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_공백일_경우_예외_발생() {
        assertThatThrownBy(() -> namesValidator.validate("pobi,,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesValidator.EMPTY_NAME_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_중복일_경우_예외_발생() {
        assertThatThrownBy(() -> namesValidator.validate("pobi,pobi,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesValidator.DUPLICATE_NAME_ERROR_MESSAGE);
    }
}
