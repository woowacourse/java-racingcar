package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차 여러 대를 만들 때 이름이 일치하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "mt,oz", "oz,mt"})
    void multiCarNameEqualTest(String text) {
        String[] carNames = text.split(",");
        List<Car> carList = Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);
        for (String carName : carNames) {
            assertThat(cars.getCars()).contains(new Car(carName));
        }
    }

    @DisplayName("자동차 여러 대가 전진했는지를 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "mt,oz", "oz,mt"})
    void carsMoveTest(String text) {
        List<Car> carList = Arrays.stream(text.split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);
        cars.move(() -> 4);
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("자동차 여러 대가 정지했는지를 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "mt,oz", "oz,mt"})
    void carsStopTest(String text) {
        List<Car> carList = Arrays.stream(text.split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);
        cars.move(() -> 3);
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @DisplayName("위치값이 가장 높은 우승자가 잘 반환되는지 테스트")
    @Test
    void winnerCarTest() {
        Cars cars = new Cars(Arrays.asList(new Car("pobi", 1),
                new Car("crong", 0),
                new Car("honux", 1)));
        assertThat(cars.getWinners()).contains(new Car("pobi"), new Car("honux"));
    }
}
