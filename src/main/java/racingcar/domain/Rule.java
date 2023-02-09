package racingcar.domain;

public enum Rule {
    MOVING_FORWARD_STANDARD(1, 4);

    private final int step;
    private final int threshold;

    Rule(int step, int threshold) {
        this.step  = step;
        this.threshold = threshold;
    }

    public int getStep() {
        return step;
    }

    public int getThreshold() {
        return threshold;
    }
}
