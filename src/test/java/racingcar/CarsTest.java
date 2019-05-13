package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    Cars testCars;

    @BeforeEach
    void setUp() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("a", 101));
        cars.add(new Car("b", 101));
        cars.add(new Car("c", 99));
        testCars = new Cars(cars);
    }

    @Test
    void carInstantiationTest() {
        String testNames = "a, b, c";
        Cars testCars1 = new Cars(testNames);
        String checkNames = "a, b, c";
        Cars checkCars2 = new Cars(checkNames);
        assertThat(testCars1).isEqualTo(checkCars2);
    }

    @Test
    void isDuplicateTest() {
        List<String> names = Arrays.asList("a", "b", "a");
        assertThrows(IllegalArgumentException.class, () -> {
            Cars.isDuplicate(names);
        });
    }

}
