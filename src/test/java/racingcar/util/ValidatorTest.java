package racingcar.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @ParameterizedTest(name = "입력이 공백이면 예외를 발생시킨다.")
    @ValueSource(strings = {"", " "})
    void validateNotEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.validateNotEmptyInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력이 자연수가 아니면 예외를 발생시킨다. - 입력값 : {0}")
    @ValueSource(strings = {"a", "-1", "", "-", "12o"})
    void validateNaturalNumberTest(String input) {
        assertThatThrownBy(() -> Validator.validateNaturalNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

}