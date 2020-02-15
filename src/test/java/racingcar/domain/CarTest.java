package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void print() {
        Car car = new Car("무늬");
        System.out.println(car.getRoundResult());
    }

    @Test
    void 자동차의_위치값이_큰_경우_양수를_반환() {
        Car greaterCar = new Car("무늬", 4);
        Car lessCar = new Car("두강", 1);

        assertThat(greaterCar.compareTo(lessCar)).isGreaterThan(0);
    }

    @Test
    void 자동차의_위치값이_작은_경우_음수를_반환() {
        Car greaterCar = new Car("무늬", 4);
        Car lessCar = new Car("두강", 1);

        assertThat(lessCar.compareTo(greaterCar)).isLessThan(0);
    }

    @Test
    void 자동차의_위치값이_같을_경우_0를_반환() {
        Position car1 = new Position(1);
        Position car2 = new Position(1);

        assertThat(car1.compareTo(car2)).isEqualTo(0);
    }
}
