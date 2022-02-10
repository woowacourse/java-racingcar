package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputValidator;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private static final int TESTCASE_NUM = 10000;
    private GameController gameController = new GameController();

    @Test
    void 자동차의_이름이_5자_이상인_경우_예외처리() {
        assertThatThrownBy(() -> {
            InputValidator.validateCarName(Arrays.asList("asd","qwerty"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_객체_생성() {
        List<String> actual = Arrays.asList("bom", "sun");
        Cars cars = gameController.initCars(actual);
        List<String> expected = cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void 랜덤_숫자_생셩() {
        for (int i = 0; i < TESTCASE_NUM; i++) {
            assertThat(RandomNumberGenerator.generate()).isBetween(0,9);
        }
    }

    @Test
    void 자동차_전진_확인() {
        Car car = new Car("qwer");
        for (int i = 0; i <= 9; i++) {
            car.move(i);
        }
        assertThat(car.getPosition()).isEqualTo(6);
    }

    @Test
    void 모든_자동차_전진_확인() {

    }
}
