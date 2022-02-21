package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("Position 음수 검증 테스트")
    @Test
    void invalid_position() {
        assertThatThrownBy(() -> Position.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Position 0이상일 경우 검증 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void valid_position(int position) {
        assertDoesNotThrow(() -> Position.from(position));
    }

    @DisplayName("Position +1증가 메서드 테스트")
    @Test
    void position_increase_test() {
        Position defaultPosition = Position.from(0);

        Position actual = defaultPosition.increase();

        assertThat(actual).isEqualTo(Position.from(1));
    }
}
