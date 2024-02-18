package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CarTest {
    @Test
    void carMoveTest() {
        Car car = new Car(new CarName("toby"));
        car.move(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void carDoesNotMoveTest() {
        Car car = new Car(new CarName("toby"));
        car.move(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
