package racingcar.domain.gameresult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.GameResult;
import racingcar.domain.GameStatus;

public class RacingGameResult implements GameResult{
    private static final String GAME_STATUS_SEPERATOR = "\n\n";
    private final List<GameStatus> gameStatusBucket = new ArrayList<>();

    public void addGameStatus(GameStatus status) {
        gameStatusBucket.add(status);
    }

    @Override
    public String getGameResult() {
        return gameStatusBucket.stream()
                .map(GameStatus::getStatus)
                .collect(Collectors.joining(GAME_STATUS_SEPERATOR));
    }
}
