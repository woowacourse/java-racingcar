package racingcargame.model;

public class CarGameRaceCount implements RaceCount{
    private static final int GAME_OVER = 0;

    private int count;

    public CarGameRaceCount(int count) {
        this.count = count;
    }

    @Override
    public void reduceRaceCount() {
        count--;
    }

    @Override
    public boolean isZeroRaceCount() {
        return count == GAME_OVER;
    }
}
