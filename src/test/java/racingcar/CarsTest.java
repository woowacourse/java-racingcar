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
    void decideMaxPositionTest() {
        assertThat(testCars.decideMaxPosition()).isEqualTo(101);
    }

    @Test
    void decideWinnersTest() {
        List<String> checkList = Arrays.asList("a", "b");
        assertThat(testCars.decideWinners()).isEqualTo(checkList);
    }

    @Test
    void carInstantiationTest() {
        List<String> testNames = Arrays.asList("a", "b", "c");
        Cars testCars1 = new Cars(testNames);
        List<String> checkNames = Arrays.asList("a", "b", "c");
        Cars checkCars2 = new Cars(checkNames);
        assertThat(testCars1).isEqualTo(checkCars2);
    }

    @Test
    void isDuplicateTest() {
        List<String> names = Arrays.asList("a", "b", "a");
        assertThrows(IllegalArgumentException.class, ()-> {
            Cars.isDuplicate(names);
        });
    }

}
