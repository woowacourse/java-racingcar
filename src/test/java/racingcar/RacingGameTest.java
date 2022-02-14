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

@SuppressWarnings("NonAsciiCharacters")
public class RacingGameTest {

    private static final int TESTCASE_NUM = 10000;
    private final GameController gameController = new GameController();

    @Test
    void 자동차의_이름이_5자_이상인_경우_예외처리() {
        assertThatThrownBy(() -> {
            InputValidator.validateCarName(Arrays.asList("asd","qwerty"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_입력시_공백이_들어간_경우() {
        final String actual = "bom, sun";
        final List<String> expected = Arrays.asList("bom", "sun");
        assertThat(gameController.splitCars(actual)).isEqualTo(expected);
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
    void 최종_우승자_출력() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("bom", 3));
        carList.add(new Car("sun", 4));
        Cars cars = new Cars(carList);

        String winnerName = gameController.findWinner(cars);
        assertThat(winnerName).contains("sun").doesNotContain("bom");
    }

    @Test
    void 자동차_이름이_하나도_존재하지_않을_경우_예외처리() {
        assertThatThrownBy(() -> {
            gameController.splitCars("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_중복이_존재하는_경우() {
        assertThatThrownBy(() -> {
            gameController.splitCars("aaa,bbb,aaa");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
