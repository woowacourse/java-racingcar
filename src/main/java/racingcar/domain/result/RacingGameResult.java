package racingcar.domain.result;

import racingcar.domain.Car;

import java.util.List;

public class RacingGameResult {
    private final List<RacingGameRound> gameResultHistory;

    public RacingGameResult(List<RacingGameRound> gameResultHistory) {
        this.gameResultHistory = gameResultHistory;
    }

    public List<RacingGameRound> getGameResultHistory() {
        return this.gameResultHistory;
    }

    public List<Car> getWinners() {
        return gameResultHistory.get(gameResultHistory.size() - 1).getWinners();
    }
}
