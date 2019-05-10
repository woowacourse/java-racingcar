package racingcar.domain.result;

import racingcar.domain.Car;

import java.util.List;

public class RacingGameResult {
    private final List<RacingGameRound> gameResultDB;

    public RacingGameResult(List<RacingGameRound> gameResultDB) {
        this.gameResultDB = gameResultDB;
    }

    public List<RacingGameRound> getGameResultDB() {
        return this.gameResultDB;
    }

    public List<Car> getWinners() {
        return this.gameResultDB.get(gameResultDB.size() - 1).getWinners();
    }
}
