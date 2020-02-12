package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarsTest {
    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Car car4;
    private static Cars cars;

    @BeforeAll
    static void setup() {
        car1 = new Car("타미", 1);
        car2 = new Car("둔덩", 7);
        car3 = new Car("라면", 2);
        car4 = new Car("유안", 7);
        cars = new Cars(Arrays.asList(car1, car2));
    }

    @Test
    void getCarTest() {
        assertThat(cars.getCar(0)).isEqualTo(car1);
        assertThat(cars.getCar(1)).isEqualTo(car2);
    }
}
