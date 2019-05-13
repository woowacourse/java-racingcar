package racingcar.domain.result;

import java.util.List;

public class RacingGameResult {
    private final List<RacingGameRound> gameResultHistory;

    public RacingGameResult(List<RacingGameRound> gameResultHistory) {
        this.gameResultHistory = gameResultHistory;
    }

    public List<RacingGameRound> getGameResultHistory() {
        return this.gameResultHistory;
    }

    public List<String> getNamesOfWinners() {
        return getLastGameRound().getNamesOfWinners();
    }

    private RacingGameRound getLastGameRound() {
        return gameResultHistory.get(gameResultHistory.size() - 1);
    }
}
