package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position;

    @BeforeEach
    void setup() {
        position = new Position(0);
    }

    @Test
    @DisplayName("이동을 위한 메서드가 작동하는지 확인한다.")
    void moveTest() {
        position.move();

        assertThat(position.getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("현재 위치값을 올바르게 기록하고 있는지 확인한다.")
    void getPositionTest() {
        assertThat(position.getPosition())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("위치값이 같으면 같은 Position으로 인식하는지 확인한다.")
    void equalsTest() {
        Position targetPosition = new Position(0);

        assertThat(position)
                .isEqualTo(targetPosition);
    }
}