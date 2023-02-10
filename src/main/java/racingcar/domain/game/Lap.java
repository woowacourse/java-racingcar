package racingcar.domain.game;

public class Lap {

    private final int totalLap;
    private int currentLap;

    public Lap(final int totalLap) {
        this.totalLap = totalLap;
    }

    public boolean hasNext() {
        return currentLap < totalLap;
    }

    public void next() {
        if (!hasNext()) {
            throw new IllegalStateException();
        }
        this.currentLap++;
    }

    public int getTotalLap() {
        return totalLap;
    }

    public int getCurrentLap() {
        return currentLap;
    }
}
