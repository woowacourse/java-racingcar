package racingcar.domain;

public class GameCount {
    private static final int MIN_COUNT = 0;
    private final int gameCount;

    public GameCount(int gameCount) {
        checkMinOfGameCount(gameCount);
        this.gameCount = gameCount;
    }

    void checkMinOfGameCount(int gameCount) {
        if (gameCount <= MIN_COUNT) {
            throw new IllegalArgumentException("게임 횟수는 " + MIN_COUNT + "이하가 될 수 없습니다.");
        }
    }

    public int getGameCount() {
        return this.gameCount;
    }

    @Override
    public boolean equals(Object object) {
        GameCount otherGameCount = (GameCount) object;
        return (this.gameCount == otherGameCount.getGameCount());
    }
}
