package racingcar.Model;

import racingcar.Controller.InputValidation;

public class TrialTime {
    private int trialTime;

    public TrialTime(String trialTime) {
        InputValidation.checkDecimalNumber(trialTime);
        InputValidation.checkNotNumber(trialTime);
        InputValidation.checkNegativeAndZeroInput(trialTime);
        InputValidation.checkIntegerOverflow(trialTime);
        this.trialTime = Integer.parseInt(trialTime);
    }

    public int getTrialTime() {
        return this.trialTime;
    }
}
