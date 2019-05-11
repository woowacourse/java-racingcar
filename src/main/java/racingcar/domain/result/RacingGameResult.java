package racingcar.domain.result;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<RacingGameRound> gameRounds;

    public RacingGameResult(List<RacingGameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    public List<RacingGameRound> getGameResult() {
        return this.gameRounds;
    }

    public List<String> getFinalWinners() {
        List<Car> winners = this.gameRounds.get(gameRounds.size() - 1).getWinners();
        return convertCarsToName(winners);
    }

    private static List<String> convertCarsToName(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
