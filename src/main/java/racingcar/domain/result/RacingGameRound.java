package racingcar.domain.result;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameRound {
    private final List<Car> players;

    public RacingGameRound(List<Car> players) {
        this.players = players;
    }

    public List<Car> getWinners() {
        Car winner = getWinner();
        return players.stream()
                .filter(car -> car.isEqualPosition(winner))
                .collect(Collectors.toList());
    }

    private Car getWinner() {
        return Collections.max(players);
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
