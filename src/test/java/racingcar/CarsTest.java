package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.Cars;
import racingcar.domain.car.Name;

public class CarsTest {

    @Test
    @DisplayName("정상적인 경주할 자동차들 생성")
    void newCarsTest_정상_입력() {
        assertThatCode(() -> {
            final List<Car> cars = new ArrayList<>();
            cars.add(new Car(new Name("루트")));
            cars.add(new Car(new Name("소롱")));
            new Cars(cars);
        }).doesNotThrowAnyException();
    }
}
