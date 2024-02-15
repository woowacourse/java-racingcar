package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("생성된 난수가 이동 기준을 만족할 때 위치가 1 증가한다.")
    void moveTest() {
        final Car car = new Car("페드로");
        final int randomNumber = 4;

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성된 난수가 이동 기준을 만족하지 않을 때 위치는 변하지 않는다.")
    void notMoveTest() {
        final Car car = new Car("몰리");
        final int randomNumber = 2;

        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
