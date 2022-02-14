package racingcargame.model;

public class RaceCount {
    private static final int GAME_OVER = 0;

    private int count;

    public RaceCount(int count) {
        this.count = count;
    }

    public void reduceCount() {
        count--;
    }

    public boolean isZeroCount() {
        return count == GAME_OVER;
    }
}
