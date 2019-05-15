package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;
    private Car car1;
    private Car car2;
    private Car car3;

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

    @Test
    void 우승1명() {
        car2.moveForward();
        car2.moveForward();
        car2.moveForward();

        List<Car> winnerList = cars.getWinnerList();

        assertThat(winnerList.size()).isEqualTo(1);
        assertThat(winnerList.contains(car1)).isFalse();
        assertThat(winnerList.contains(car2)).isTrue();
        assertThat(winnerList.contains(car3)).isFalse();
    }

    @Test
    void 우승2명() {
        car2.moveForward();
        car2.moveForward();
        car2.moveForward();

        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        List<Car> winnerList = cars.getWinnerList();

        assertThat(winnerList.size()).isEqualTo(2);
        assertThat(winnerList.contains(car1)).isFalse();
        assertThat(winnerList.contains(car2)).isTrue();
        assertThat(winnerList.contains(car3)).isTrue();
    }
}
