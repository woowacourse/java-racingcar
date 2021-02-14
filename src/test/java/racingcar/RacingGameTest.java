package racingcar;

import racingcar.controller.RacingGame;
import racingcar.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    RacingGame racingGame = new RacingGame();
    @Test
    @DisplayName("입력값을 쉼표 단위로 나눠서 리스트 객체로 반환한다.")
    public void splitInputTest() throws Exception {
        List<String> splittedInput = racingGame.splitInput("Ryan,Pika");
        List<String> expected = Arrays.asList("Ryan", "Pika");
        assertThat(splittedInput).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("게임 시행 횟수는 1 이상의 숫자여야 한다.")
    @ValueSource(strings = {"  ", " as", "b3"})
    void isValidNumberTest(String number) {
        assertThrows(IllegalArgumentException.class, () -> racingGame.isValidNumber(number));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void findWinnersTest() {
        List<Car> cars = Arrays.asList(
                new Car("Babo", 5),
                new Car("Ryan", 3),
                new Car("Pika", 5)
        );
        racingGame.assignCars(cars);

        assertThat(racingGame.findWinners()).isEqualTo(Arrays.asList(
                new Car("Babo", 5),
                new Car("Pika", 5)));
    }
}
