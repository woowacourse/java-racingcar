package racingcar;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void moveForward() {
        Car car = new Car(new CarName("ser"));
        int previous = car.getPosition();
        car.moveForwardByRandomNumber(5);
        assertEqual(car.getPosition(), previous + 1);
    }
}
