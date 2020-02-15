package racingcar.domain;

public class MaxPosition {
    private final int maxPosition;

    public MaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    public boolean isMaxPosition(int position) {
        return maxPosition == position;
    }
}
