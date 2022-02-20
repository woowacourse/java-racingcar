package racingcar.domain;

import racingcar.utils.ExceptionMessage;

public class TrialCount {
    private static final String ZERO_AND_POSITIVE_DIGIT = "^[0-9]*$";

    private int trialCount;

    public TrialCount(String inputTrialCount) {
        validatePositiveDigit(inputTrialCount);
        this.trialCount = Integer.parseInt(inputTrialCount);
    }

    public void minus(){
        trialCount--;
    }

    private void validatePositiveDigit(String inputString) {
        if (!inputString.matches(ZERO_AND_POSITIVE_DIGIT) || inputString.equals("0")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_DIGIT);
        }
    }

    public boolean isRemain() {
        return this.trialCount > 0;
    }
}
