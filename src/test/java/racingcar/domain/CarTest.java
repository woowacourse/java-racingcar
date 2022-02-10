package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    Car car = new Car("sudal");

    @Test
    void 자동차_위치_이동() {
        car.move();

        Car other = new Car("pobi");
        other.move();
        assertTrue(car.isSamePosition(other));
    }

    // TODO: car.hasNext() 테스트 추가
}