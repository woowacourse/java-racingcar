package racingcar.domain.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.InvalidTextException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameValidationTest {
    int maxLength = 5;

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "brown"})
    public void 정상_입력_시(String name) {
        NameValidation.validateName(name, maxLength);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi#", "bro."})
    public void 문자_외의_입력_시_예외처리(String name) {
        assertThatThrownBy(() -> NameValidation.validateName(name, maxLength))
                .isInstanceOf(InvalidTextException.class);
    }
}