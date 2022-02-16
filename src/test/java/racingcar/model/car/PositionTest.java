package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.create();
    }

    @Nested
    @DisplayName("increase 메소드는")
    class Increase {
        @Test
        @DisplayName("현재 위치에 1을 더한 Position을 리턴한다.")
        void it_returns_Position_of_one_plus_value() {
            assertThat(position.increase()).isEqualTo(Position.from(1));
        }
    }

    @Nested
    @DisplayName("from 메소드는")
    class From {

        @Nested
        @DisplayName("입력값이 음수가 아니라면")
        class Context_with_not_negative_number {
            @ParameterizedTest
            @DisplayName("Position을 반환한다.")
            @ValueSource(ints = {0, 1, 11})
            void it_returns_Position(int input) {
                assertDoesNotThrow(() -> Position.from(input));
            }
        }

        @Nested
        @DisplayName("입력값이 음수라면")
        class Context_with_negative_number {
            @ParameterizedTest
            @DisplayName("예외를 발생시킨다.")
            @ValueSource(ints = {-1, -22})
            void it_throw_exception(int input) {
                assertThatThrownBy(() -> Position.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
