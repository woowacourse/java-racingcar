package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = Position.create();
    }

    @Test
    void 위치_값_증가() {
        assertThat(position.increase()).isEqualTo(Position.from(1));
    }

    @DisplayName("from 메소드는")
    @Nested
    class from {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 11})
        void 입력값이_음수가_아니라면(int input) {
            assertDoesNotThrow(() -> Position.from(input));
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -22})
        void 입력값이_음수라면(int input) {
            assertThatThrownBy(() -> Position.from(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
