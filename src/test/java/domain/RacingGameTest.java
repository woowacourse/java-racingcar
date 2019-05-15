package domain;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void playTrial_올바르게적용되었는지() {
        List<Car> cars = Arrays.asList(
                new Car("a", 10),
                new Car("b", 0),
                new Car("c", 19)
        );
        RacingGame racingGame = new RacingGame(cars, 10);

        Deque<Boolean> dequeueMoveds = new LinkedList(Arrays.asList(true, false, true));
        Predicate<Integer> strategy = (num) -> dequeueMoveds.pollFirst();


        assertThat(racingGame.playTrial(strategy)).isEqualTo(Arrays.asList(
                new MovedCar("a", 11),
                new MovedCar("b", 0),
                new MovedCar("c", 20)
        ));
    }

    @Test
    void isFinished_numTrials이0() {
        RacingGame racingGame = new RacingGame(new ArrayList<Car>(), 0);

        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    void isFinished_numTrials이0이아닐때() {
        RacingGame racingGame = new RacingGame(new ArrayList<Car>(), 1);

        assertThat(racingGame.isFinished()).isFalse();
    }
}