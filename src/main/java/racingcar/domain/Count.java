package racingcar.domain;

public class Count {

    private final int targetCount;
    private int now = 0;

    public Count(int targetCount) {
        this.targetCount = targetCount;
    }

    public boolean isFinished() {
        return now >= targetCount;
    }

    public void next() {
        now++;
    }
}
