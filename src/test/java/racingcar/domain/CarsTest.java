package racingcar.domain;


import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private final Cars cars = new Cars();
    private final List<String> carNames = Arrays.asList("aaa", "bbb", "ccc");

    @BeforeEach
    void createAndSaveCars() {
        cars.createCarsByCarNames(carNames);
    }

    @DisplayName("리스트의 자동차 객체들 모두 저장 및 반환, 불변 테스트")
    @Test
    void saveAllCars() {
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

    @DisplayName("모든 자동차들의 위치값들 중 최댓값")
    @Test
    void getMaxPositionOfAllCars() {
        List<Car> allSavedCars = cars.getAllCars();
        int goForwardNumber = 5;
        allSavedCars.get(0).goForwardDependsOnNumber(goForwardNumber);
        allSavedCars.get(0).goForwardDependsOnNumber(goForwardNumber);
        allSavedCars.get(0).goForwardDependsOnNumber(goForwardNumber);

        allSavedCars.get(1).goForwardDependsOnNumber(goForwardNumber);
        allSavedCars.get(1).goForwardDependsOnNumber(goForwardNumber);

        allSavedCars.get(2).goForwardDependsOnNumber(goForwardNumber);

        int maxPosition = 3;
        Assertions.assertThat(cars.getMaxPosition()).isEqualTo(maxPosition);
    }
}