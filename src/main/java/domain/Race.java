package domain;

public class Race {

    private final int TOTAL_COUNT;
    private int currentCount = 0;

    public Race(final int totalCount) {
        this.TOTAL_COUNT = totalCount;
    }

    public void addCount() {
        currentCount += 1;
    }

    public boolean isFinished() {
        return TOTAL_COUNT == currentCount;
    }
}
