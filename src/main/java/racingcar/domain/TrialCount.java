package racingcar.domain;

import racingcar.utils.ExceptionMessage;

public class TrialCount {

    private int trialCount;

    public TrialCount(int inputTrialCount) {
        validatePositiveDigit(inputTrialCount);
        this.trialCount = inputTrialCount;
    }

    public void minus(){
        trialCount--;
    }

    private void validatePositiveDigit(int inputTrialCount) {
        if(inputTrialCount <= 0){
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_DIGIT);
        }
    }

    public boolean isRemain() {
        return this.trialCount > 0;
    }
}
