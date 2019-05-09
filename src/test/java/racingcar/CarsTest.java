package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;
    Car car4;

    @BeforeEach
    void setup() {
        cars = new Cars();
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        car4 = new Car("d");
    }

    @Test
    void 자동차추가() {
        assertThat(cars.size()).isEqualTo(0);

        cars.addCar(new Car("a"));
        cars.addCar(new Car("b"));
        cars.addCar(new Car("c"));

        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 최댓값() {
        assertThat(cars.getMaxPosition()).isEqualTo(0);

        car2.moveForward(cars);
        car2.moveForward(cars);
        car2.moveForward(cars);

        assertThat(cars.getMaxPosition()).isEqualTo(3);
    }

    @Test
    void 우승1() {
        car2.moveForward(cars);
        car2.moveForward(cars);
        car2.moveForward(cars);

        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);

        assertThat(cars.getWinnerList().size()).isEqualTo(1);
    }

    @Test
    void 우승2() {
        car2.moveForward(cars);
        car2.moveForward(cars);
        car2.moveForward(cars);

        car4.moveForward(cars);
        car4.moveForward(cars);
        car4.moveForward(cars);

        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);

        assertThat(cars.getWinnerList().size()).isEqualTo(2);
    }
}
