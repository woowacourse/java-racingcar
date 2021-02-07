package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {

    static List<Car> testingCars = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        testingCars.add(new Car("java"));
        testingCars.add(new Car("html"));
        CarRepository.addCars(testingCars);
    }

    @Test
    void addCars() {
        assertEquals(testingCars, CarRepository.cars());
    }

    @Test
    void collectWinners() {
        assertThat(CarRepository.collectWinnerNames()).isEqualTo("java, html");
    }
}