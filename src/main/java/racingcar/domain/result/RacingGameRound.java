package racingcar.domain.result;

import racingcar.domain.Car;

import java.util.List;

public class RacingGameRound {
    private final List<Car> players;

    public RacingGameRound(List<Car> players) {
        this.players = players;
    }
}
