package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @DisplayName("자동차 전진 테스트")
    @Test
    void moveForward() {
        Car car = new Car(new CarName("ser"));
        int previous = car.getPosition();
        car.moveForwardByNumber(5);
        assertEquals(car.getPosition(), previous + 1);
    }
}
