package racingcar.model.trycount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {
    @DisplayName("생성자는")
    @Nested
    class New {
        @Nested
        @DisplayName("양수가 주어지면")
        class Context_with_positive_number {
            @ParameterizedTest
            @DisplayName("TryCount 객체를 반환한다.")
            @ValueSource(ints = {1, 11})
            void it_returns_try_count(int input) {
                assertDoesNotThrow(() -> new TryCount(input));
            }
        }

        @Nested
        @DisplayName("양수가 아니라면")
        class Context_with_not_positive_number {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(ints = {0, -1, -22})
            void it_throw_exception(int input) {
                assertThatThrownBy(() -> new TryCount(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
