package racingcar;

import org.junit.jupiter.api.DisplayName;
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
    private final GameController gameController = new GameController();

    @Test
    @DisplayName("자동차명 입력시 공백이 들어간 경우")
    void inputSpaceBetweenCarNames() {
        final String actual = "bom, sun";
        final List<String> expected = Arrays.asList("bom", "sun");
        assertThat(gameController.splitCars(actual)).isEqualTo(expected);
    }

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
    @DisplayName("랜덤 숫자 생성")
    void generateRandomNumber() {
        for (int i = 0; i < TESTCASE_NUM; i++) {
            assertThat(RandomNumberGenerator.generate()).isBetween(0,9);
        }
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

    @Test
    @DisplayName("최종 우승자 출력")
    void findWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("bom", 3));
        carList.add(new Car("sun", 4));
        Cars cars = new Cars(carList);

        String winnerName = gameController.findWinner(cars);
        assertThat(winnerName).contains("sun").doesNotContain("bom");
    }

    @Test
    @DisplayName("자동차 이름이 하나도 존재하지 않을 경우 예외처리")
    void blankInputException() {
        assertThatThrownBy(() -> gameController.splitCars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에 중복이 존재하는 경우 예외처리")
    void duplicateCarNamesException() {
        assertThatThrownBy(() -> gameController.splitCars("aaa,bbb,aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상인 경우 예외처리")
    void exceededMaxCarNameLengthException() {
        assertThatThrownBy(() -> InputValidator.validateCarName(Arrays.asList("asd","qwerty")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
