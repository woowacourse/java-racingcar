package racingcar.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRacingGameTest {

    @DisplayName("시도 횟수가 음수일 경우 예외를 발생한다.")
    @Test
    void negativeMoveCountTest() {
        // given
        int moveCount = -1;
        Cars cars = new Cars(List.of(new Car("자동차1")));

        // when & then
        Assertions.assertThatThrownBy(() -> new CarRacingGame(cars, moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차들이 전진한다.")
    @Test
    void goTest() {
        //given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));
        CarRacingGame carRacingGame = new CarRacingGame(cars, 1);

        List<Integer> expected = List.of(1, 1);

        //when
        CarMoveRule rule = () -> true;
        carRacingGame.moveCars(rule);

        //then
        Assertions.assertThat(cars.stream()
                        .map(Car::getProgress)
                        .toList())
                .isEqualTo(expected);
    }

    @DisplayName("자동차들이 정지한다.")
    @Test
    void stopTest() {
        //given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));
        CarRacingGame carRacingGame = new CarRacingGame(cars, 1);

        List<Integer> expected = List.of(0, 0);

        //when
        CarMoveRule rule = () -> false;
        carRacingGame.moveCars(rule);

        //then
        Assertions.assertThat(cars.stream()
                        .map(Car::getProgress)
                        .toList())
                .isEqualTo(expected);
    }

    @DisplayName("우승자를 판별한다")
    @Test
    void findWinnersTest() {
        //given
        Car winner = new Car("win");
        Car loser = new Car("lose");

        //when
        winner.move();
        Cars cars = new Cars(List.of(winner, loser));
        CarRacingGame carRacingGame = new CarRacingGame(cars, 1);

        //then
        Cars actual = carRacingGame.findWinners();
        Assertions.assertThat(actual.stream()
                        .findFirst()
                        .orElseThrow())
                .isEqualTo(winner);
    }

    @DisplayName("시도 횟수가 1~300 범위를 벗어나면 예외를 발생한다.")
    @ValueSource(ints = {-1, 0, 301})
    @ParameterizedTest
    void validateTest() {
        //given
        Cars cars = new Cars(List.of(new Car("자동차1")));
        int moveCount = 0;

        //when & then
        Assertions.assertThatThrownBy(() -> new CarRacingGame(cars, moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
