package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setup() {
        cars = new Cars();
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
    }

    @Test
    void 자동차추가() {
        assertThat(cars.size()).isEqualTo(3);
    }

//    @Test
//    void 최댓값() {
//        assertThat(cars.getMaxPosition()).isEqualTo(0);
//
//        car2.moveForward(cars);
//        car2.moveForward(cars);
//        car2.moveForward(cars);
//
//        assertThat(cars.getMaxPosition()).isEqualTo(3);
//    }
//
//    @Test
//    void 우승1명() {
//        car2.moveForward(cars);
//        car2.moveForward(cars);
//        car2.moveForward(cars);
//
//        assertThat(cars.getWinnerList().size()).isEqualTo(1);
//    }
//
//    @Test
//    void 우승2명() {
//        car2.moveForward(cars);
//        car2.moveForward(cars);
//        car2.moveForward(cars);
//
//        car3.moveForward(cars);
//        car3.moveForward(cars);
//        car3.moveForward(cars);
//
//        assertThat(cars.getWinnerList().size()).isEqualTo(2);
//    }
}
