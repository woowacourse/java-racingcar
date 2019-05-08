package racingcar;

import org.junit.jupiter.api.Test;

public class RacingCarTest {


    @Test
    void moveTest() {
        Car car = new Car("testCar");
        car.move(new ForceMove());
    }


}

// 코드 포함?
class ForceMove implements Car.MovableStrategy {
    public boolean isMove() {
        return true;
    }
}