package racingcar.model.vo;

import racingcar.util.InputValidator;

public class TrialNum {
    private final int trialNum;

    public TrialNum(int trialNum) {
        this.trialNum = trialNum;
    }

    public static TrialNum initTrialNum(String number) {
        return new TrialNum(convertToInteger(number));
    }

    private static int convertToInteger(String number) {
        InputValidator.validateTrialInput(number);
        return Integer.parseInt(number);
    }

    public int getTrialNum() {
        return trialNum;
    }
}
