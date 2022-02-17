package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static final int TESTCASE_NUM = 10000;

    @Test
    @DisplayName("랜덤 숫자 생성")
    void generateRandomNumber() {
        final NumberGenerator randomNumber = new RandomNumberGenerator();
        for (int i = 0; i < TESTCASE_NUM; i++) {
            assertThat(randomNumber.generate()).isBetween(0,9);
        }
    }

    @Test
    @DisplayName("최종 우승자 출력")
    void findWinner() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Name("bom"), 3));
        carList.add(new Car(new Name("sun"), 4));
        Cars cars = new Cars(carList);

        String actual = cars.findWinnerName(cars.findMaxPosition()).stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        assertThat(actual).contains("sun").doesNotContain("bom");
    }
}
