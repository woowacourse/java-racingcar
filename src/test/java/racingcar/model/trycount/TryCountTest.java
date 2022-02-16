package racingcar.model.trycount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {
    @DisplayName("from 메소드는")
    @Nested
    class from {
        @Nested
        @DisplayName("숫자가 아닌 문자가 주어지면")
        class Context_with_string {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {"a", "", "12a", "-"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> TryCount.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("양수가 주어지면")
        class Context_with_positive_number {
            @ParameterizedTest
            @DisplayName("TryCount 객체를 반환한다.")
            @ValueSource(strings = {"1", "11"})
            void it_returns_TryCount(String input) {
                assertDoesNotThrow(() -> TryCount.from(input));
            }
        }

        @Nested
        @DisplayName("양수가 아니라면")
        class Context_with_not_positive_number {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(strings = {"0", "-1", "-22"})
            void it_throw_exception(String input) {
                assertThatThrownBy(() -> TryCount.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
