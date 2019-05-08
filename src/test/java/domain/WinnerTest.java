package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    ArrayList<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi", 3));
        carList.add(new Car("crong", 4));
        carList.add(new Car("honux", 5));
    }

    @Test
    void maxPositionTest() {
        Car car = carList.get(0);
        assertThat(car.compareToPosition(5)).isEqualTo(5);
    }
}
