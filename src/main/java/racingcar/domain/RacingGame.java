package racingcar.domain;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static final int MIN_NUM_OF_CARS_FOR_GAME = 2;
    private final RacingGamePlayers players;
    private final GameCount gameCount;

    public RacingGame(RacingGamePlayers players, GameCount gameCount) {
        this.players = players;
        this.gameCount = gameCount;
    }

    public RacingGameResult start() {
        List<RacingGameRound> gameResultHistory = new ArrayList<>();
        for (int i = 0; i < gameCount.getGameCount(); i++) {
            players.proceedOneRound();
            gameResultHistory.add(new RacingGameRound(players));
        }
        return new RacingGameResult(gameResultHistory);
    }
}
