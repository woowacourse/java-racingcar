package domain;

import exception.RacingGameNoTrialLeftException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameTest {
    @Test
    void doTrial_() {
        Trial trial = Trial.from(1);
        int numCars = 2;
        Distance distance = Distance.from(10);
        RacingGame racingGame = RacingGame.of(TestCars.generateCars(numCars, distance), trial);

        assertThat(racingGame.doTrial(TestMoveStrategy.MOVE)).isEqualTo(TestCars.generateCars(numCars, distance.increased()));
    }

    @Test
    void doTrial_EMPTY_trial시도() {
        Trial trial = Trial.EMPTY;
        int numCars = 2;
        Distance distance = Distance.from(10);
        RacingGame racingGame = RacingGame.of(TestCars.generateCars(numCars, distance), trial);

        assertThrows(RacingGameNoTrialLeftException.class, () -> racingGame.doTrial(TestMoveStrategy.MOVE));
    }

    @Test
    void doTrial_특정횟수_시도() {
        int numTrial = 3;
        Trial trial = Trial.from(numTrial);
        int numCars = 2;
        Distance distance = Distance.from(10);
        RacingGame racingGame = RacingGame.of(TestCars.generateCars(numCars, distance), trial);

        for (int i = 0; i < numTrial; i++) {
            racingGame.doTrial(TestMoveStrategy.MOVE);
        }

        assertThat(racingGame.hasTrial()).isFalse();
    }

    @Test
    void findWinners_승자1명() {
        int distance = 10;
        Cars cars = generateCars(
                Arrays.asList("1", "2", "3"),
                Arrays.asList(distance, distance, distance + 1));
        Cars winners = generateCars(
                Arrays.asList("3"),
                Arrays.asList(distance + 1));
        RacingGame racingGame = RacingGame.of(cars, Trial.EMPTY);

        assertThat(racingGame.findWinners()).isEqualTo(winners);
    }

    @Test
    void findWinners_승자2명() {
        int distance = 10;
        Cars cars = generateCars(
                Arrays.asList("1", "2", "3"),
                Arrays.asList(distance + 1, distance, distance + 1));
        Cars winners = generateCars(
                Arrays.asList("1", "3"),
                Arrays.asList(distance + 1, distance + 1));
        RacingGame racingGame = RacingGame.of(cars, Trial.EMPTY);

        assertThat(racingGame.findWinners()).isEqualTo(winners);
    }

    private Cars generateCars(List<String> names, List<Integer> distances) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            cars.add(Car.of(names.get(i), Distance.from(distances.get(i))));
        }
        return Cars.from(cars);
    }

}