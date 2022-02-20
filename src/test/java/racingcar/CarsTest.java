package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 자동차_이름이_하나도_존재하지_않을_경우_예외처리() {
        List<Car> cars = Collections.emptyList();

        assertThatThrownBy(() -> {
            Cars.initCars(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_중복이_존재하는_경우_예외처리() {
        Car car1 = new Car("aaa");
        Car car2 = new Car("bbb");
        Car car3 = new Car("aaa");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        assertThatThrownBy(() -> {
            Cars.initCars(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승자_자동차_확인() {
        Car car1 = new Car("bom", 3);
        Car car2 = new Car("sun", 4);
        Car car3 = new Car("asdf", 4);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        assertThat(cars.findWinnerCars().getCars().size()).isEqualTo(2);
    }
}
