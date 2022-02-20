package racingCar.domain.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingCar.utils.InputValidator.validate;

import org.junit.jupiter.api.Test;
import racingCar.exception.NullInputException;

@SuppressWarnings("NonAsciiCharacters")
public class InputViewValidatorTest {
    @Test
    void validate_null() {
        assertThatThrownBy(() -> validate(null))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void validate_빈문자열() {
        assertThatThrownBy(() -> validate(""))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void validate_그냥문자() {
        assertThat(validate("hunch"))
                .isEqualTo("hunch");
    }

    @Test
    void validate_그냥숫자() {
        assertThat(validate("5"))
                .isEqualTo("5");
    }
}