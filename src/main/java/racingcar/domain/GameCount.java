package racingcar.domain;

import java.util.Objects;

public class GameCount {
    public static final int MIN_COUNT = 1;
    private final int gameCount;

    public GameCount(int gameCount) {
        checkMinGameCount(gameCount);
        this.gameCount = gameCount;
    }

    private void checkMinGameCount(int gameCount) {
        if (gameCount < MIN_COUNT) {
            throw new IllegalArgumentException("게임 횟수는 " + MIN_COUNT + " 미만의 수가 될 수 없습니다.");
        }
    }

    public int getGameCount() {
        return this.gameCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCount gameCount = (GameCount) o;
        return this.gameCount == gameCount.gameCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameCount);
    }
}
