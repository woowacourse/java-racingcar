package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position;

    @BeforeEach
    void setup() {
        position = new Position();
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
        Position targetPosition = new Position();

        assertThat(position)
                .isEqualTo(targetPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,-3", "1,-1", "0,0"})
    @DisplayName("자동차 위치 비교를 정확하게 하는지 검증한다.")
    void compareToTest(int otherPosition, int expected) {
        Position movingPosition = new Position();
        for (int i = 0; i < otherPosition; i++) {
            movingPosition.move();
        }

        assertThat(position.compareTo(movingPosition))
                .isEqualTo(expected);
    }
}