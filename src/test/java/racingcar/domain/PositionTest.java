package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    private Position position;

    @BeforeEach
    void init() {
        position = new Position(0);
    }

    @DisplayName("위치 업데이트 확인")
    @Test
    void updatePosition() {
        position.updatePosition();

        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("최대값과 비교하여 최대값 반환 확인")
    @Test
    void compareAndFindPosition() {
        int maxPosition = 1;

        assertThat(position.compareAndFindPosition(maxPosition)).isEqualTo(1);
    }

    @DisplayName("현재 위치가 최대 위치와 같은지 확인")
    @Test
    void isSamePosition() {
        int winnerPosition = 0;

        assertThat(position.isSamePosition(winnerPosition)).isTrue();
    }
}
