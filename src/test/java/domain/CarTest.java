package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    ArrayList<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi", 3));
        carList.add(new Car("crong", 4));
        carList.add(new Car("honux", 5));
    }

    @Test
    void isMoveTest() {
        assertThat(Car.isMove(4)).isEqualTo(true);
        assertThat(Car.isMove(2)).isEqualTo(false);
    }

    @Test
    void maxPositionTest() {
        Car car = carList.get(0);
        assertThat(car.updateMaxPosition(5)).isEqualTo(5);
    }

    @Test
    void compareToPositionTest() {
        Car car = carList.get(0);
        assertThat(car.compareToPosition(3)).isEqualTo(true);
        assertThat(car.compareToPosition(4)).isEqualTo(false);
    }
}
