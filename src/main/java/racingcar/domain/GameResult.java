package racingcar.domain;

import java.util.List;

public class GameResult{
    private final List<GameStatus> status;
    private final GameWinner winners;

    public GameResult(List<GameStatus> status, GameWinner winners) {
        this.status = status;
        this.winners = winners;
    }

    public List<GameStatus> getGameStatus() {
        return status;
    }
    
    public GameWinner getWinners() {
        return winners;
    }
    
}

