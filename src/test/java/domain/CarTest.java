package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void compare() {
        Car carA = new Car("CarA");
        Car carB = new Car("CarB");
        List<Car> cars = new ArrayList<>(List.of(carA, carB));
        carA.move();

        Assertions.assertThat(Collections.max(cars)).isEqualTo(carA);
    }
}
