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
        assertThrows(IllegalArgumentException.class, () -> new racingcar.domain.Cars(input));
    }

    @Test
    @DisplayName("자동차들을 이동시킬 수 있다.")
    void moveCars() {
        racingcar.domain.Cars cars = new racingcar.domain.Cars("pobi,crong,honux");
        cars.moveCars(() -> 4);

        List<racingcar.domain.Car> carList = cars.getCars();
        for (racingcar.domain.Car car : carList) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}