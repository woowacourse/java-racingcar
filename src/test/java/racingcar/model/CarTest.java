package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarsTest.AlwaysMoveNumberGenerator;
import racingcar.model.CarsTest.NoMoveNumberGenerator;

class CarTest {

    @DisplayName("전진하는 경우")
    @Test
    void goPassable() {
        Car car = Car.from("a");

        car.go(new AlwaysMoveNumberGenerator());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("전진하지 않는 경우")
    @Test
    void cantGo() {
        Car car = Car.from("a");

        car.go(new NoMoveNumberGenerator());

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
