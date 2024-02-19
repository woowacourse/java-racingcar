package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String GAME_STATUS_SEPERATOR = "\n\n";
    private final List<GameStatus> gameStatusBucket = new ArrayList<>();

    public void addGameStatus(GameStatus status) {
        gameStatusBucket.add(status);
    }

    public String getGameResult() {
        return gameStatusBucket.stream()
                .map(GameStatus::getStatus)
                .collect(Collectors.joining(GAME_STATUS_SEPERATOR));
    }
}
