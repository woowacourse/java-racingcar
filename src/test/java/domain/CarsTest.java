package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarsTest {

    @Test
    void getCarTest() {
        Car car1 = new Car("타미");
        Car car2 = new Car("둔덩");

        Cars cars = new Cars(Arrays.asList(car1, car2));

        assertThat(cars.getCar(0)).isEqualTo(car1);
        assertThat(cars.getCar(1)).isEqualTo(car2);
    }
}
