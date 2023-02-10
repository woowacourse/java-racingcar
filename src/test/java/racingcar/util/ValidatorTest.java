package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest(name = "입력이 공백이면 예외를 발생시킨다.")
    @NullAndEmptySource
    void validateNotEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.validateNotEmptyInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력이 자연수가 아니면 예외를 발생시킨다. - 입력값 : {0}")
    @ValueSource(strings = {"2", "1000"})
    void validateNaturalNumberNormalCaseTest(String input) {
        assertDoesNotThrow(() -> Validator.validateNaturalNumber(input));
    }

    @ParameterizedTest(name = "입력이 null이거나 공백이면 예외를 발생시킨다.")
    @NullAndEmptySource
    void validateNaturalNumberNullOrEmptyTest(String input) {
        assertThatThrownBy(() -> Validator.validateNaturalNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력이 자연수가 아니면 예외를 발생시킨다. - 입력값 : {0}")
    @ValueSource(strings = {"a", "-1", "", "-", "12o"})
    void validateNaturalNumberTest(String input) {
        assertThatThrownBy(() -> Validator.validateNaturalNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

}