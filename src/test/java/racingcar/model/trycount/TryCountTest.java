package racingcar.model.trycount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TryCountTest {
    @DisplayName("from 메소드는")
    @Nested
    class from {
        @ParameterizedTest
        @ValueSource(strings = {"a", "", "12a", "-"})
        void 숫자가_아닌_문자라면(String input) {
            assertThatThrownBy(() -> TryCount.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "11"})
        void 양수라면(String input) {
            assertDoesNotThrow(() -> TryCount.from(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "-1", "-22"})
        void 양수가_아니라면(String input) {
            assertThatThrownBy(() -> TryCount.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
