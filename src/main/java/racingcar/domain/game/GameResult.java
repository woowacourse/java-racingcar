package racingcar.domain.game;

import racingcar.domain.car.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameResult {

    private final List<String> winnerNames;

    public GameResult(final List<Car> winners) {
        this.winnerNames = winners.stream()
                .map(it -> it.getName().getValue())
                .collect(toList());
    }

    public List<String> winnerNames() {
        return winnerNames;
    }
}
