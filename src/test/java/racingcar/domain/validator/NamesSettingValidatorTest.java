package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException;
import racingcar.validator.NamesSettingValidator;

public class NamesSettingValidatorTest {

    private NamesSettingValidator namesSettingValidator;

    @BeforeEach
    public void setUp() {
        namesSettingValidator = new NamesSettingValidator();
    }

    @Test
    public void 입력값이_null일_경우_예외_발생() {
        assertThatThrownBy(() -> namesSettingValidator.validate(null))
                .isInstanceOf(CarNameException.class).hasMessage(NamesSettingValidator.NULL_INPUT_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_6글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> namesSettingValidator.validate("pobiisawesome,jason,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesSettingValidator.INVALID_LENGTH_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_공백일_경우_예외_발생() {
        assertThatThrownBy(() -> namesSettingValidator.validate("pobi,,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesSettingValidator.EMPTY_NAME_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_중복일_경우_예외_발생() {
        assertThatThrownBy(() -> namesSettingValidator.validate("pobi,pobi,crong"))
                .isInstanceOf(CarNameException.class).hasMessage(NamesSettingValidator.DUPLICATE_NAME_ERROR_MESSAGE);
    }
}
