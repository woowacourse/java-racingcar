package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
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
        List<String> carNames = Arrays.asList("bom", "sun");
        List<Car> expected = gameController.initCars(carNames);
        List<String> expectedNameList = expected.stream().map(Car::getName).collect(Collectors.toList());

        assertThat(expectedNameList).isEqualTo(carNames);
    }

    @Test
    void 랜덤_숫자_생셩() {
        for (int i = 0; i < TESTCASE_NUM; i++) {
            assertThat(RandomNumberGenerator.generate()).isBetween(0,9);
        }
    }
}
