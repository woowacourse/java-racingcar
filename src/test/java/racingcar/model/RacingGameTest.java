package racingcar.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;
import racingcar.domain.model.CarMoveRule;
import racingcar.domain.model.Cars;
import racingcar.domain.model.RacingGame;

public class RacingGameTest {

    @DisplayName("시도 횟수가 음수일 경우 예외를 발생한다.")
    @Test
    void negativeMoveCountTest() {
        // given
        int moveCount = -1;
        Cars cars = new Cars(List.of(new Car("자동차1")));

        // when & then
        Assertions.assertThatThrownBy(() -> new RacingGame(cars, moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 움직임 룰에 부합하면 1씩 전진한다.")
    @Test
    void goTest() {
        //given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));
        RacingGame racingGame = new RacingGame(cars, 1);

        List<Integer> expected = List.of(1, 1);

        //when
        CarMoveRule rule = () -> true;
        racingGame.move(rule);

        //then
        Assertions.assertThat(cars.stream().map(Car::getProgress).toList()).isEqualTo(expected);
    }

    @DisplayName("자동차는 룰의 조건에 따라 전진하지 않기도 한다.")
    @Test
    void stopTest() {
        //given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2")));
        RacingGame racingGame = new RacingGame(cars, 1);

        List<Integer> expected = List.of(0, 0);

        //when
        CarMoveRule rule = () -> false;
        racingGame.move(rule);

        //then
        Assertions.assertThat(cars.stream().map(Car::getProgress).toList()).isEqualTo(expected);
    }

    @DisplayName("가장 먼거리를 이동한 우승자를 판별한다")
    @Test
    void findWinnersTest() {
        //given
        Car winner = new Car("win");
        Car loser = new Car("lose");

        //when
        winner.move();
        Cars cars = new Cars(List.of(winner, loser));
        RacingGame racingGame = new RacingGame(cars, 1);

        //then
        Cars actual = racingGame.findWinners();
        Assertions.assertThat(actual.stream().findFirst().orElseThrow()).isEqualTo(winner);
    }

    @DisplayName("시도 횟수는 1~300 벗어나면 예외를 발생한다.")
    @Test
    void validateTest() {
        //given
        Cars cars = new Cars(List.of(new Car("자동차1")));
        int moveCount = 0;

        //when & then
        Assertions.assertThatThrownBy(() -> new RacingGame(cars, moveCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
