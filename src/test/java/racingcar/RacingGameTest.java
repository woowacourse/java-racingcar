package racingcar;

import org.junit.jupiter.api.BeforeEach;
import racingcar.controller.RacingGame;
import racingcar.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    RacingGame game;

    @BeforeEach
    public void init(){
        game = new RacingGame();
    }

    @Test
    @DisplayName("입력값을 쉼표 단위로 나눠서 리스트 객체로 반환한다.")
    public void splitInputTest() throws Exception {
        List<String> splittedInput = game.splitInput("Ryan,Pika");
        List<String> expected = Arrays.asList("Ryan", "Pika");
        assertThat(splittedInput).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("게임 시행 횟수는 1 이상의 숫자여야 한다.")
    @ValueSource(strings = {"  ", " as", "b3"})
    void isValidNumberTest(String number) {
        assertThrows(IllegalArgumentException.class, () -> game.isValidNumber(number));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void findWinnersTest() {
        List<Car> carList = Arrays.asList(
                new Car("Babo", 5),
                new Car("Ryan", 3),
                new Car("Pika", 5)
        );
        Cars cars = new Cars(carList);
        assertThat(game.findWinners(cars)).isEqualTo(Arrays.asList(
                new Car("Babo", 5),
                new Car("Pika", 5)));
    }
}
