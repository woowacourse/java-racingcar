package utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberValidatorTest {

    @ParameterizedTest
    @CsvSource({"''", "abc", "-1", "0"})
    void validateTest1(String input) {
        assertThatThrownBy(() -> NumberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource({"1", "5"})
    void validateTest2(String input) {
        assertThatCode(() -> NumberValidator.validate(input))
                .doesNotThrowAnyException();
    }
}