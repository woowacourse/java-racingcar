package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi,pobi"})
    @DisplayName("자동차의 수가 1보다 작거나, 중복되는 이름을 가지면 예외가 발생한다.")
    void duplicateCarNamesTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Cars(input));
    }

    @Test
    @DisplayName("random 값이 4일 경우, 자동차들을 이동시킬 수 있다.")
    void moveCarsTest() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.moveCars(() -> 4);

        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("ramdom 값이 3인 경우 자동차들은 이동하지 않는다.")
    void notMoveCarsTest() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.moveCars(() -> 3);

        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차들을 찾을 수 있다.")
    void findCarsAtMaxPosition() {
        Cars cars = new Cars("pobi,crong,honux");
        List<Car> carsAtMaxPosition = cars.findCarsAtMaxPosition();

        assertThat(carsAtMaxPosition.size()).isEqualTo(3);
    }
}