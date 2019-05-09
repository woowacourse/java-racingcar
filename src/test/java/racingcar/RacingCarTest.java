package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MovableStrategy;

public class RacingCarTest {

    @Test
    void moveTest() {
        Car car = new Car("testCar");
        car.move(new ForceMove());
    }


}

class ForceMove implements MovableStrategy {
    public boolean isMovable() {
        return true;
    }
}