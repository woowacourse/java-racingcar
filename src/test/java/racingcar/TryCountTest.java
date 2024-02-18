package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.TryCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {

    @Nested
    class ValidateInput {
        @Test
        @DisplayName("입력값이 문자이면 예외를 발생한다.")
        void testIsNotNumeric() {
            String given = "문자열";

            assertThatThrownBy(() -> new TryCount(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값이 음수이면 예외를 발생한다.")
        void testIsMinusValue() {
            String given = "-1";

            assertThatThrownBy(() -> new TryCount(given))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
