package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(
                List.of(new Car("pobi"), new Car("crong"), new Car("honux"))
        );
    }

    @Test
    @DisplayName("자동차의 수가 1보다 작거나, 중복되는 이름을 가지면 예외가 발생한다.")
    void invalidCarNamesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Cars(Collections.emptyList()));
        assertThrows(IllegalArgumentException.class, () ->
                new Cars(List.of(new Car("pobi"), new Car("pobi"))));
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "3, 0"})
    @DisplayName("random 값이 4 이상일 경우 자동차들을 이동시키고, random 값이 4 미만인 경우 자동차들을 이동시키지 않는다.")
    void moveTest(int randomNumber, int expected) {
        cars.moveCars(() -> randomNumber);

        List<Car> carList = cars.getCars();
        carList.forEach(car -> assertThat(car.getPosition()).isEqualTo(expected));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차들을 찾을 수 있다.")
    void findCarsAtMaxPosition() {
        cars = new Cars(
                Arrays.asList(new Car("pobi", 3), new Car("crong", 1), new Car("honux", 3))
        );
        List<Car> carsAtMaxPosition = cars.findCarsAtMaxPosition();

        assertThat(carsAtMaxPosition).extracting("name")
                .containsExactly("pobi", "honux");
    }
}
