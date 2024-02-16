package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void carMoveTest() {
        Car car = new Car(new CarName("toby"));
        int power = 6;
        car.move(power);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carDoesNotMoveTest() {
        Car car = new Car(new CarName("toby"));
        int power = 1;
        car.move(power);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
