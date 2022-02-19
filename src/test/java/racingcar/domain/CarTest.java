package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차가 움직인다")
    public void car_move() {
        // given
        Car car = Car.carBuilder().setCarName("foo").build();

        // when & then
        assertThat(car.getPositionForTest()).isEqualTo(0);
        car.moveOrHold(true);
        assertThat(car.getPositionForTest()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 움직이지 않는다")
    public void car_not_move() {
        // given
        Car car = Car.carBuilder().setCarName("foo").build();

        // when & then
        assertThat(car.getPositionForTest()).isEqualTo(0);
        car.moveOrHold(false);
        assertThat(car.getPositionForTest()).isEqualTo(0);
    }
}
