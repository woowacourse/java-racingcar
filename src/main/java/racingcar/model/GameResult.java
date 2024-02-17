package racingcar.model;

import java.util.List;

public class GameResult{
    private final List<GameStatus> status;
    private final GameWinners winners;

    public GameResult(List<GameStatus> status, GameWinners winners) {
        this.status = status;
        this.winners = winners;
    }

    public List<GameStatus> getGameStatus() {
        return status;
    }
    
    public GameWinners getWinners() {
        return winners;
    }
    
}

