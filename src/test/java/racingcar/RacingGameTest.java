package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingGame;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private static final int ANY_INT = 1;

    private final Car car1 = new Car("car1");
    private final Car car2 = new Car("car2");
    private final List<Car> cars = new ArrayList<>();
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        cars.add(car1);
        cars.add(car2);
        racingGame = new RacingGame(cars, ANY_INT);
    }

    @Test
    void 우승자를_선출한다_우승자가_한명인경우() {
        car1.attemptToMove(4);
        car2.attemptToMove(3);

        assertThat(racingGame.findWinners()).containsExactly(car1);
    }

    @Test
    void 우승자를_선출한다_우승자가_두명인경우() {
        car1.attemptToMove(4);
        car2.attemptToMove(4);

        assertThat(racingGame.findWinners()).containsExactly(car1, car2);
    }




}