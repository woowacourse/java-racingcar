package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {
    @Test
    void create() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));

        assertThat(new WinnerCars(cars)).isEqualTo(new WinnerCars(cars));
    }
}
