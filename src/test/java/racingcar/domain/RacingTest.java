package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @Test
    void 랜덤숫자가_4이상일때만_움직인다() {
        Car car = new Car("Test");
        int beforePosition = car.getPosition();

        car.moveOrNot(3);
        assertTrue(beforePosition == car.getPosition());

        car.moveOrNot(4);
        assertTrue((beforePosition + 1) == car.getPosition());
    }
}