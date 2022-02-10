package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StringValidatorTest {
    @DisplayName("validateIsEmpty 메소드는")
    @Nested
    class validateIsEmpty {
        @ParameterizedTest
        @ValueSource(strings = {""})
        void 빈_값_이라면(String input) {
            assertThatThrownBy(() -> StringValidator.validateIsEmpty(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열은 빈값이면 안됩니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "1111"})
        void 빈_값이_아니라면(String input) {
            assertDoesNotThrow(() -> StringValidator.validateIsEmpty(input));
        }
    }
}