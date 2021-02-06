package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int INIT_ROUND = 1;

    private final Cars cars;
    private int round;

    public RacingGame(List<String> names) {
        this.cars = Cars.createCarsByNames(names);
        this.round = INIT_ROUND;
    }

    public void playRound() {
        cars.moveCars();
        round++;
    }

    public GameResult findWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }
}
