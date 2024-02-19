package racingcar.domain;

public interface GameResult {
    void addGameStatus(GameStatus status);

    String getGameResult();
}
