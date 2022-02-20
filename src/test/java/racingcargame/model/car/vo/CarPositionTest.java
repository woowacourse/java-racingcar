package racingcargame.model.car.vo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    @DisplayName("자동차 위치값이 정상적으로 증가하는지 테스트")
    @Test
    void move_Test() {
        CarPosition carPosition = new CarPosition();
        final int moveValue = 2;
        carPosition.move(2);

        assertThat(carPosition.getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차 위치값끼리 정상적으로 비교하는지 테스트")
    @Test
    void compareTo_Test() {
        CarPosition first = new CarPosition();
        CarPosition second = new CarPosition();
        first.move(3);
        second.move(4);

        assertThat(first.equals(second)).isEqualTo(false);
    }

    @DisplayName("자동차 위치값끼리 정상적으로 비교하는지 테스트")
    @Test
    void compareTo_Test2() {
        CarPosition first = new CarPosition();
        CarPosition second = new CarPosition();
        first.move(5);
        second.move(4);

        assertThat(first.equals(second)).isEqualTo(false);
    }
}