package domain;

import dto.TurnResult;
import java.util.List;

public class GameResult {
    private final List<TurnResult> gameResult;

    public GameResult(List<TurnResult> gameResult) {
        this.gameResult = gameResult;
    }

    public List<TurnResult> getGameResult() {
        return gameResult;
    }
}
