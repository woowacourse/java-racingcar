package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    CarList carList;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setup() {
        carList = new CarList();
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        carList.addCar(car1);
        carList.addCar(car2);
        carList.addCar(car3);
    }

    @Test
    void 자동차추가() {
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
    void 우승1명() {
        car2.moveForward(carList);
        car2.moveForward(carList);
        car2.moveForward(carList);

        assertThat(carList.getWinnerList().size()).isEqualTo(1);
    }

    @Test
    void 우승2명() {
        car2.moveForward(carList);
        car2.moveForward(carList);
        car2.moveForward(carList);

        car3.moveForward(carList);
        car3.moveForward(carList);
        car3.moveForward(carList);

        assertThat(carList.getWinnerList().size()).isEqualTo(2);
    }
}
