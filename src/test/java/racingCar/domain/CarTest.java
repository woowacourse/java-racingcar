package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private final Car car = new Car("test", 0);

    @Test
    @DisplayName("3 이하의 값이 move()에 들어간 경우, 이동하지 않음")
    void moveTest_notMove() {
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("4 이상의 값이 move()에 들어간 경우, 이동")
    void moveTest_move() {
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("position이 같은 경우")
    void isSamePosition_same() {
        assertThat(car.isSamePosition(0)).isTrue();
    }

    @Test
    @DisplayName("position이 다른 경우")
    void isSamePosition_different() {
        assertThat(car.isSamePosition(1)).isFalse();
    }
}
