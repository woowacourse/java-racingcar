package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

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
}
