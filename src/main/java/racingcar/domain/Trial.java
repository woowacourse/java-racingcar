package racingcar.domain;

import java.util.Objects;

public class Trial {
    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;

    private final int finalTrialNumber;
    private int currentTrialNumber;

    public Trial(final int finalTrialNumber) {
        validateBound(finalTrialNumber);
        this.finalTrialNumber = finalTrialNumber;
        this.currentTrialNumber = 0;
    }

    private static void validateBound(final int value) {
        if (value < MIN_TRIAL || value > MAX_TRIAL) {
            throw new IllegalArgumentException(
                "숫자는 " + MIN_TRIAL + "이상 " + MAX_TRIAL + "이하여야 합니다.");
        }
    }

    public void moveToNextTrial() {
        currentTrialNumber++;
    }

    public boolean isFinished() {
        return currentTrialNumber >= finalTrialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trial trial = (Trial) o;
        return finalTrialNumber == trial.finalTrialNumber
            && currentTrialNumber == trial.currentTrialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalTrialNumber, currentTrialNumber);
    }
}
