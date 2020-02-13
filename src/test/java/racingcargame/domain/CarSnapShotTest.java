package racingcargame.domain;

import org.junit.jupiter.api.Test;
import racingcargame.domain.car.Car;
import racingcargame.domain.result.CarSnapShot;

import static org.assertj.core.api.Assertions.assertThat;

public class CarSnapShotTest {

    @Test
    void createCarSnapShotFromCar() {
        Car car = new Car("제이");
        car.move(4);
        car.move(4);
        car.move(4);
        car.move(4);

        CarSnapShot carSnapShot = new CarSnapShot(car);
        assertThat(carSnapShot.getStatus()).isEqualTo("제이   : ----");
    }
}
