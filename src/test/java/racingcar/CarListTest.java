package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    CarList carList;
    Car car1;
    Car car2;
    Car car3;
    Car car4;

    @BeforeEach
    void setup() {
        carList = new CarList();
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        car4 = new Car("d");
    }

    @Test
    void 자동차추가() {
        assertThat(carList.size()).isEqualTo(0);

        carList.addCar(new Car("a"));
        carList.addCar(new Car("b"));
        carList.addCar(new Car("c"));

        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    void 최댓값() {
        assertThat(carList.getMaxPosition()).isEqualTo(0);

        car2.moveForward(carList);
        car2.moveForward(carList);
        car2.moveForward(carList);

        assertThat(carList.getMaxPosition()).isEqualTo(3);
    }

    @Test
    void 우승1() {
        car2.moveForward(carList);
        car2.moveForward(carList);
        car2.moveForward(carList);

        carList.addCar(car1);
        carList.addCar(car2);
        carList.addCar(car3);
        carList.addCar(car4);

        assertThat(carList.getWinnerList().size()).isEqualTo(1);
    }

    @Test
    void 우승2() {
        car2.moveForward(carList);
        car2.moveForward(carList);
        car2.moveForward(carList);

        car4.moveForward(carList);
        car4.moveForward(carList);
        car4.moveForward(carList);

        carList.addCar(car1);
        carList.addCar(car2);
        carList.addCar(car3);
        carList.addCar(car4);

        assertThat(carList.getWinnerList().size()).isEqualTo(2);
    }
}
