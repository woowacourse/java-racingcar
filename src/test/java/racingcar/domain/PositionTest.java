package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionTest {
    @Test
    @DisplayName("position 생성 확인")
    void positionCreate() {
        Position position = new Position();
        assertEquals(position.getPosition(), 0);
    }

    @Test
    @DisplayName("position 이동 확인")
    void positionMove() {
        Position position = new Position();
        position = position.moveForward();
        assertEquals(position.getPosition(), 1);
    }

    @Test
    @DisplayName("position 같은 위치 확인")
    void positionIsSameThan() {
        Position position = new Position();
        assertTrue(position.isSameThan(0));
    }

    @Test
    @DisplayName("더 큰 위치 숫자 반환")
    void positionGetBiggerPosition() {
        Position position = new Position();
        assertThat(position.findBiggerPosition(3)).isEqualTo(3);
    }
}
