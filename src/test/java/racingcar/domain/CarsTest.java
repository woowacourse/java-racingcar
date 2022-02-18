package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_CARS_EMPTY;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("getWinners 메서드는 가장 position 값이 큰 car 객체들을 반환한다")
    @Test
    void getWinners() {
        Cars cars = new Cars();

        Car juneCar = new Car("june", 0);
        Car pobiCar = new Car("pobi", 5);
        Car romaCar = new Car("roma", 5);

        cars.add(juneCar);
        cars.add(pobiCar);
        cars.add(romaCar);

        List<Car> winners = cars.getWinners();
        assertThat(winners).containsExactly(pobiCar, romaCar);
    }

    @DisplayName("getWinners 메서드는 List<Car>이 비어있으면 예외를 발생시킨다.")
    @Test
    void getWinners_errorOnEmpty() {
        Cars cars = new Cars();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(cars::getWinners)
                .withMessageMatching(ERROR_CARS_EMPTY);
    }
}
