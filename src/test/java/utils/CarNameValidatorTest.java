package utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameValidatorTest {

    @ParameterizedTest
    @CsvSource({"''", "abcdef"})
    void validateTest1(String input) {
        assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource({"a", "abcde"})
    void validateTest2(String input) {
        assertThatCode(() -> CarNameValidator.validate(input))
                .doesNotThrowAnyException();
    }
}