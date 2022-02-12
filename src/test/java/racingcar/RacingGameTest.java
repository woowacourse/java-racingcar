package racingcar;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 우승자를_선출한다_우승자가_한명인경우() {
        // given
        RacingGame racingGame = new RacingGame();
        Car car1 = new Car();
        Car car2 = new Car();
        List<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);

        // when
        car1.attemptToMove(4);
        car2.attemptToMove(3);

        // then
        assertThat(racingGame.findWinners(cars)).containsExactly(car1);
    }

    @Test
    void 우승자를_선출한다_우승자가_두명인경우() {
        // given
        RacingGame racingGame = new RacingGame();
        Car car1 = new Car();
        Car car2 = new Car();

        List<Car> cars = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);

        // when
        car1.attemptToMove(4);
        car2.attemptToMove(4);

        // then
        assertThat(racingGame.findWinners(cars)).containsExactly(car1, car2);
    }




}