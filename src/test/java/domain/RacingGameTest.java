package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void playTrial_전부움직이기() {
        List<Car> cars = Arrays.asList(
                Car.create("a", 1, () -> true),
                Car.create("b", 2, () -> true),
                Car.create("c", 3, () -> true));
        RacingGame racingGame = new RacingGame(1);

        assertThat(racingGame.playTrial(cars)).isEqualTo(Arrays.asList(
                Car.create("a", 2),
                Car.create("b", 3),
                Car.create("c", 4)));
        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    void playTrial_전부정지() {
        List<Car> cars = Arrays.asList(
                Car.create("a", 1, () -> false),
                Car.create("b", 2, () -> false),
                Car.create("c", 3, () -> false));
        RacingGame racingGame = new RacingGame(1);

        assertThat(racingGame.playTrial(cars)).isEqualTo(Arrays.asList(
                Car.create("a", 1),
                Car.create("b", 2),
                Car.create("c", 3)));
        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    void isFinished_numTrials이0() {
        RacingGame racingGame = new RacingGame(0);

        assertThat(racingGame.isFinished()).isTrue();
    }

    @Test
    void isFinished_numTrials이0이아닐때() {
        RacingGame racingGame = new RacingGame(1);

        assertThat(racingGame.isFinished()).isFalse();
    }
}