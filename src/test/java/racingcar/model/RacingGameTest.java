package racingcar.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @DisplayName("자동차들이 전진한다.")
    @Test
    void goTest() {
        //given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));
        RacingGame racingGame = new RacingGame(cars);

        List<Integer> expected = List.of(1, 1);

        //when
        RaceRule rule = () -> true;
        racingGame.move(rule);

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
        RacingGame racingGame = new RacingGame(cars);

        List<Integer> expected = List.of(0, 0);

        //when
        RaceRule rule = () -> false;
        racingGame.move(rule);

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
        Car winner = new Car("winner");
        Car loser = new Car("loser");

        //when
        winner.move();
        Cars cars = new Cars(List.of(winner, loser));
        RacingGame racingGame = new RacingGame(cars);

        //then
        Cars actual = racingGame.findWinners();
        Assertions.assertThat(actual.stream()
                        .findFirst()
                        .orElseThrow())
                .isEqualTo(winner);
    }
}
