package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @ParameterizedTest(name = "입력이 공백이면 예외를 발생시킨다.")
    @ValueSource(strings = {"", " "})
    void validateNotEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.validateNotEmptyInput(input)).isInstanceOf(IllegalArgumentException.class);
    }
}