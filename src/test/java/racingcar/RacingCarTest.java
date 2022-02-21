package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 저장")
    public void saveCarNames() {
        final CarController controller = new CarController(new Scanner(System.in));
        final List<Car> cars = controller.saveCars(new String[]{"pobi","crong","honux"});
        final List<String> carNames = cars.stream()
                    .map(Car::getName)
                    .collect(Collectors.toList());
        assertThat(carNames)
                .contains("pobi")
                .contains("crong")
                .contains("honux");
    }

    @Test
    @DisplayName("4 이상이면 전진, 3 이하면 정지")
    public void moveAndStop() {
        final Car car = new Car("pobi");
        final Car stopCar = car.race(3);
        final Car moveCar = car.race(4);
        assertThat(stopCar.getPosition()).isEqualTo(0);
        assertThat(moveCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 에러를 발생")
    public void longerThanFive() {
        final String input = "javaji";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final CarController controller = new CarController(new Scanner(System.in));
        assertThatThrownBy(() -> controller.scanCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
