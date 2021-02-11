package racingcar.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Trial {

    private static final Integer TRIAL_MIN = 1;
    private static final Integer TRIAL_MAX = Integer.MAX_VALUE;

    private final int finalTrialNumber;
    private int currentTrialNumber;

    public Trial(final int finalTrialNumber) {
        validateBound(finalTrialNumber);
        this.finalTrialNumber = finalTrialNumber;
        this.currentTrialNumber = 0;
    }

    private static void validateBound(final int value) {
        if (value < TRIAL_MIN || value > TRIAL_MAX) {
            throw new IllegalArgumentException(
                "숫자는 " + TRIAL_MIN + "이상 " + TRIAL_MAX + "이하여야 합니다.");
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
