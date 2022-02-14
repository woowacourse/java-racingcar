package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.utils.numbergenerator.MovableNumberGenerator;

public class CarsTest {

    @Test
    void 자동차_2개_미만() {
        assertThatThrownBy(() -> new Cars(new String[]{"rick"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 자동차_5개_초과() {
        assertThatThrownBy(
                () -> new Cars(new String[]{"rick", "huni", "sudal", "ukong", "tomy", "pobi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차는 2대 이상 5대 이하이어야 합니다.");
    }

    @Test
    void 자동차_우승_1명_성공() {
        Car jaeCar = new Car("jae", new MovableNumberGenerator());
        Car rickCar = new Car("rick", new MovableNumberGenerator());

        for (int i = 0; i < 3; i++) {
            moveCarPosition(rickCar);
        }
        Cars cars = new Cars(new ArrayList<>(Arrays.asList(jaeCar, rickCar)));

        assertThat(cars.getWinners()).isEqualTo("rick가 최종 우승 했습니다.");
    }

    @Test
    void 자동차_우승_2명_성공() {
        Car jaeCar = new Car("jae", new MovableNumberGenerator());
        Car rickCar = new Car("rick", new MovableNumberGenerator());

        for (int i = 0; i < 3; i++) {
            moveCarPosition(rickCar, jaeCar);
        }
        Cars cars = new Cars(new ArrayList<>(Arrays.asList(jaeCar, rickCar)));

        assertThat(cars.getWinners()).isEqualTo("jae, rick가 최종 우승 했습니다.");
    }

    private void moveCarPosition(Car... car) {
        for (Car c : car) {
            c.goForward();
        }
    }
}