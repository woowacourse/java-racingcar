package racingcar.domain.result;

import racingcar.domain.Car;

import java.util.List;

public class RacingGameRound {
    private final List<Car> players;

    public RacingGameRound(List<Car> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car player : players) {
            stringBuilder.append(player);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
