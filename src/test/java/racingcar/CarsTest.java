package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    Cars testCars;

    @BeforeEach
    void setUp() {
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(new Car("a", 101), new Car("b", 101),
                new Car("c", 99)));
        testCars = new Cars(cars);
    }

    @Test
    void 객체가_생성되는지_확인() {
        String testNames = "a, b, c";
        Cars testCars1 = new Cars(testNames);
        String checkNames = "a, b, c";
        Cars checkCars2 = new Cars(checkNames);
        assertThat(testCars1).isEqualTo(checkCars2);
    }

    @Test
    void 중복된_값을_확인() {
        List<String> names = Arrays.asList("a", "b", "a");
        assertThrows(IllegalArgumentException.class, () -> {
            Cars.isDuplicate(names);
        });
    }

}
