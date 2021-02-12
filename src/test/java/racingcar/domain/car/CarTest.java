package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 전진하고 3 이하의 값이면 멈춘다.")
    public void move_랜덤_값이_4_이상일_경우_전진하고_3_이하의_값이면_멈춘다() {
        Car car = new Car("pobi", i -> 6);
        car.move();
        assertTrue(car.isSamePosition(1));

        car = new Car("pobi", i -> 3);
        car.move();
        assertTrue(car.isSamePosition(0));
    }
}