package racingcar.domain.result;

import java.util.List;

public class RacingGameResult {
    private final List<RacingGameRound> gameResultDB;

    public RacingGameResult(List<RacingGameRound> gameResultDB) {
        this.gameResultDB = gameResultDB;
    }

    public List<RacingGameRound> getGameResultDB() {
        return this.gameResultDB;
    }
}
