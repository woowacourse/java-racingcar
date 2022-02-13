package racingcargame.model;

public class ImmovableRaceCount implements RaceCount{
    private int count;

    public ImmovableRaceCount(int count) {
        this.count = count;
    }

    @Override
    public void reduceRaceCount() {
        count -= 3;
    }

    @Override
    public boolean isZeroRaceCount() {
        return count == 0;
    }
}
