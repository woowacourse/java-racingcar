package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private ArrayList<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));

        carList.get(0).move(2);
        carList.get(1).move(9);
    }

    @Test
    void isMoveTest() {
        assertThat(Car.isMove(4)).isEqualTo(true);
        assertThat(Car.isMove(2)).isEqualTo(false);
    }

    @Test
    void maxPositionTest() {
        Car car = carList.get(1);
        assertThat(car.getLargePosition(5)).isEqualTo(5);
        assertThat(car.getLargePosition(0)).isEqualTo(1);
    }

    @Test
    void compareToPositionTest() {
        Car car = carList.get(1);
        assertThat(car.compareToPosition(1)).isEqualTo(true);
        assertThat(car.compareToPosition(2)).isEqualTo(false);
    }
}
