package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void moveForward() {
        Car car = new Car(new CarName("ser"));
        int previous = car.getPosition();
        car.moveForwardByRandomNumber(5);
        assertEquals(car.getPosition(), previous + 1);
    }
}
