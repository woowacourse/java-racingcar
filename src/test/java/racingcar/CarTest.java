package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.FixedNumberGenerator;
import racingcar.util.NumberGenerator;

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

    @ParameterizedTest
    @DisplayName("특정 값을 통한 자동차 비전진 확인")
    @ValueSource(ints = {0, 1, 2, 3})
    void notMoveTest(int num) {
        NumberGenerator numberGenerator = new FixedNumberGenerator(num);
        Car car = new Car("sun");
        car.move(numberGenerator);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("특정 값을 통한 자동차 전진 확인")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int num) {
        NumberGenerator numberGenerator = new FixedNumberGenerator(num);
        Car car = new Car("sun");
        car.move(numberGenerator);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
