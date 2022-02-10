package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {
    @DisplayName("validateIsEmpty 메소드는")
    @Nested
    class validateIsEmpty {
        @ParameterizedTest
        @ValueSource(strings = {""})
        void 빈값이라면(String input) {
            assertThatThrownBy(() -> Name.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "aa"})
        void 빈값이_아니라면(String input) {
            assertDoesNotThrow(() -> Name.from(input));
        }
    }
}
