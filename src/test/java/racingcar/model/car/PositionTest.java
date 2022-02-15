package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("from 메소드에 정상범위의 숫자를 전달하면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 11})
    void fromWithValidInput(int input) {
        assertDoesNotThrow(() -> Position.from(input));
    }

    @DisplayName("increase 메소드를 실행하면 1만큼 더 큰 Position 인스턴스를 반환한다.")
    @Test
    void increase() {
        assertThat(position.increase()).isEqualTo(Position.from(1));
    }

    @DisplayName("from 메소드에 음수값이 전달되면 예외가 발생 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -22})
    void fromWithNegative(int input) {
        assertThatThrownBy(() -> Position.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
