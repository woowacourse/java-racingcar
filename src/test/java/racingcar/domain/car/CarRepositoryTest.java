package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {

    @Test
    void addCars() {
        List<Car> testingCars = new ArrayList<>();
        testingCars.add(new Car("java"));
        testingCars.add(new Car("html"));
        CarRepository.addCars(testingCars);
        assertEquals(testingCars, CarRepository.cars());
    }

    @Test
    void collectWinners() {
        List<Car> testingCars = new ArrayList<>();
        testingCars.add(new Car("java"));
        testingCars.add(new Car("html"));
        CarRepository.addCars(testingCars);
        assertThat(CarRepository.collectWinners()).isEqualTo("java, html");
    }
}