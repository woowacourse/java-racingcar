package racingcar.model;

import java.util.List;

public class Result {
    private final Winner winner;

    public Result(List<Car> cars, int maxPosition) {
        this.winner = new Winner(cars, maxPosition);
    }

    public Winner getWinner() {
        return winner;
    }
}
