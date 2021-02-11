package racingcar.domain;


import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("리스트의 자동차 객체들 모두 저장 및 반환, 불변 테스트")
    @Test
    void saveAllCars() {
        Cars cars = new Cars();
        List<String> carNames = Arrays.asList("aaa", "bbb", "ccc");

        cars.createCarsByCarNames(carNames);
        List<Car> allSavedCars = cars.getAllCars();

        Assertions.assertThat(allSavedCars.size()).isEqualTo(3);

        Assertions.assertThat(
            allSavedCars.stream()
                .allMatch(car -> carNames.contains(car.getName()))
        ).isTrue();

        Assertions.assertThatThrownBy(
            () -> allSavedCars.add(new Car("test"))
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}