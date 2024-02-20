import static org.assertj.core.api.Assertions.assertThat;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("4 이상의 숫자가 주어졌을 경우 전진하는지 확인")
    @Test
    void checkMove() {
        Car car = Car.from("a");

        car.move(4);

        assertThat(car.getCarLocation()).isEqualTo(1);
    }

    @DisplayName("4 이히의 숫자가 주어졌을 경우 멈춰있는지 확인")
    @Test
    void checkStop() {
        Car car = Car.from("a");

        car.move(3);

        assertThat(car.getCarLocation()).isEqualTo(0);
    }

}
