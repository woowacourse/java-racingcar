package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "aru,kelly,polla,roki,siso"})
    @DisplayName("이름이 주어지면, 자동차를 올바르게 생성한다.")
    void createCarTest(String input) {
        // given
        CarFactory carFactory = new CarFactory(() -> 1);
        List<String> carNames = Arrays.stream(input.split(",")).toList();

        // when
        List<Car> cars = carFactory.createCars(carNames);
        List<String> actual = cars.stream()
                .map(Car::getStatus)
                .map(CarStatus::name).toList();

        // then
        assertThat(actual).containsExactlyElementsOf(carNames);
    }
}
