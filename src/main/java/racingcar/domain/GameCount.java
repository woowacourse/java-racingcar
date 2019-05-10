package racingcar.domain;

import java.util.Objects;

public class GameCount {
    public static final int MIN_COUNT = 0;

    private final int gameCount;

    public GameCount(int gameCount) {
        checkMinOfGameCount(gameCount);
        this.gameCount = gameCount;
    }

    private void checkMinOfGameCount(int gameCount) {
        if (gameCount <= MIN_COUNT) {
            throw new IllegalArgumentException("게임 횟수는 " + MIN_COUNT + "이하가 될 수 없습니다.");
        }
    }

    public int getGameCount() {
        return this.gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameCount)) return false;
        GameCount gameCount1 = (GameCount) o;
        return gameCount == gameCount1.gameCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameCount);
    }
}
