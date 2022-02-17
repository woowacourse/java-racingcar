package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("자동차 위치값이 정상적으로 증가하는지 테스트")
    @Test
    void move_Test() {
        Position position = new Position();
        int moveValue = 2;
        position.move(2);

        assertThat(position.getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차 위치값끼리 정상적으로 비교하는지 테스트")
    @Test
    void compareTo_Test() {
        Position first = new Position();
        Position second = new Position();
        first.move(3);
        second.move(4);

        assertThat(first.compareTo(second)).isEqualTo(-1);
    }

    @DisplayName("자동차 위치값끼리 정상적으로 비교하는지 테스트")
    @Test
    void compareTo_Test2() {
        Position first = new Position();
        Position second = new Position();
        first.move(5);
        second.move(4);

        assertThat(first.compareTo(second)).isEqualTo(1);
    }
}