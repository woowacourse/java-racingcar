package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveSuccessTest() {
        Car car = new Car("name");
        Integer nowDistance = car.getDistance();

        car.move(true);

        Assertions.assertThat(car.getDistance()).isEqualTo(nowDistance + 1);
    }

    @Test
    void moveFailTest() {
        Car car = new Car("name");
        Integer nowDistance = car.getDistance();

        car.move(false);

        Assertions.assertThat(car.getDistance()).isEqualTo(nowDistance);
    }
}
