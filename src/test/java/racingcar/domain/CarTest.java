package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Location;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_이름이_빈_문자열인_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> {
            Car.validateEmptyName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자초과인_경우_예외_처리() {
        String input = "두강두강무늬무늬";
        assertThatThrownBy(() -> {
            Car.validateNameLength(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void print() {
        Car car = new Car("무늬");
        System.out.println(car.getResult());
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
        Location car1 = new Location(1);
        Location car2 = new Location(1);

        assertThat(car1.compareTo(car2)).isEqualTo(0);
    }
}
