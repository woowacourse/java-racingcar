package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final GameController gameController = new GameController();

    @Test
    @DisplayName("자동차 객체 생성")
    void createCarObject() {
        List<String> actual = Arrays.asList("bom", "sun");
        Cars cars = gameController.initCars(actual);
        List<String> expected = cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("자동차 전진 확인")
    void moveCarForward() {
        Car car = new Car("qwer");
        for (int i = 0; i <= 9; i++) {
            car.move(i);
        }
        assertThat(car.getPosition()).isEqualTo(6);
    }
}
