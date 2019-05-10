package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private ArrayList<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));

        cars.get(0).move(3);
        cars.get(1).move(4);
    }

    @Test
    void create_Car() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void isMoveTest() {
        assertThat(Car.isMove(4)).isTrue();
        assertThat(Car.isMove(3)).isFalse();
    }

    @Test
    void getLargePositionTest() {
        Car car = cars.get(1);
        assertThat(car.getLargePosition(5)).isEqualTo(5);
        assertThat(car.getLargePosition(0)).isEqualTo(1);
    }

    @Test
    void compareToPositionTest() {
        Car car = cars.get(1);
        assertThat(car.compareToPosition(1)).isTrue();
        assertThat(car.compareToPosition(2)).isFalse();
    }
}
