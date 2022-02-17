package racingCar.controller.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingCar.controller.service.InputValidator.validate;

import org.junit.jupiter.api.Test;
import racingCar.domain.exception.NullInputException;

@SuppressWarnings("NonAsciiCharacters")
public class InputValidatorTest {
    @Test
    void requestNames_null() {
        assertThatThrownBy(() -> validate(null))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_빈문자열() {
        assertThatThrownBy(() -> validate(""))
                .isInstanceOf(NullInputException.class)
                .hasMessage("1자 이상 입력해주세요.");
    }

    @Test
    void requestNames_그냥문자() {
        assertThat(validate("hunch"))
                .isEqualTo("hunch");
    }

    @Test
    void requestNames_그냥숫자() {
        assertThat(validate("5"))
                .isEqualTo("5");
    }
}