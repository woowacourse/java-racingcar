package racingcar;

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

    @Test
    @DisplayName("입력값을 쉼표 단위로 나눠서 리스트 객체로 반환한다.")
    public void splitInputTest() throws Exception {
        List<String> splittedInput= RacingGame.splitInput("Ryan,Pika");
        List<String> expected = Arrays.asList("Ryan","Pika");
        assertThat(splittedInput).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("게임 시행 횟수는 1 이상의 숫자여야 한다.")
    @ValueSource(strings = {"  ", " as", "b3"})
    void isValidNumberTest(String number){
        assertThrows(IllegalArgumentException.class, () -> RacingGame.isValidNumber(number));
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승한다.")
    void findWinnersTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car("Babo", 5),
                new Car("Ryan", 3),
                new Car("Pika", 5)
        ));
        RacingGame.cars = cars;
        cars.updateMaxDistance();
        assertThat(RacingGame.findWinners()).isEqualTo(Arrays.asList(
                new Car("Babo", 5),
                new Car("Pika", 5)));
    }
}
