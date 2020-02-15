package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVED_DISTANCE = 1;

    @Test
    void 주어진_양수에_따라_자동차를_전진() {
        Car car = new Car("무늬", DEFAULT_POSITION);
        car.moveByNumber(0);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);

        car = new Car("무늬", DEFAULT_POSITION);
        car.moveByNumber(3);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);

        car = new Car("무늬", DEFAULT_POSITION);
        car.moveByNumber(4);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + MOVED_DISTANCE);

        car = new Car("무늬", DEFAULT_POSITION);
        car.moveByNumber(9);
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + MOVED_DISTANCE);
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
