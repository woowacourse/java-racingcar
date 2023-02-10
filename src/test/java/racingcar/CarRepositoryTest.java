package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRepositoryTest {
    @BeforeEach
    @MethodSource
    void setUp() {
        Car pobi = new Car("pobi", 2);
        Car mery = new Car("mery", 3);
        Car abel = new Car("abel", 2);
        List<Car> cars = List.of(pobi, mery, abel);
        CarRepository.updateCars(cars);
    }

    @Test
    void findAll() {
        List<String> carNames = CarRepository.findAll()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());

        assertThat(carNames).isEqualTo(List.of("pobi", "mery", "abel"));
    }

    @Test
    void findSamePositionWith() {
        assertThat(CarRepository.findMaxPosition(3)).isEqualTo(List.of("mery"));
    }

    @ParameterizedTest
    @MethodSource("provideCars")
    void numberOfCarsException(List<Car> cars) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarRepository.updateCars(cars));
    }

    private static Stream<Arguments> provideCars() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(new Car("pobi", 0)))
        );
    }

    @AfterEach
    void clear() {
        CarRepository.clear();
    }
}