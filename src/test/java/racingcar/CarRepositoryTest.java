package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThat(CarRepository.findSamePositionWith(3)).isEqualTo(List.of("mery"));
    }
}