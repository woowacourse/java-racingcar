package car.domain;

public class TrialCount {

    private static final int MIN_TRIAL_COUNT = 0;
    private static final int DECREASE_AMOUNT = 1;

    private final int left;

    public TrialCount(int left) {
        validateNotNegative(left);
        this.left = left;
    }

    private void validateNotNegative(int left) {
        if (left < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("시도횟수는 음수이면 안됩니다");
        }
    }

    public TrialCount decrease() {
        return new TrialCount(left - DECREASE_AMOUNT);
    }

    public boolean isLeft() {
        return left > MIN_TRIAL_COUNT;
    }
}
