package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Round {

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");
    private static final int TRIAL_COUNT_MIN_NUMBER = 1;
    private static final int FINISH = 0;
    private static final String TRIAL_COUNT_INPUT_ERROR = "[ERROR] 시도 횟수는 숫자이어야 합니다.";
    private static final String TRIAL_COUNT_NUMBER_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다.";

    private int trialCount;

    public Round(String trialCount) {
        validateTrialCount(trialCount);
        this.trialCount = Integer.parseInt(trialCount);
    }

    public boolean isPossibleToRacing() {
        return this.trialCount != FINISH;
    }

    public void minusTrialCount() {
        trialCount--;
    }

    private void validateTrialCount(String trialCount) {
        Matcher matcher = pattern.matcher(trialCount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(TRIAL_COUNT_INPUT_ERROR);
        }
        if (Integer.parseInt(trialCount) < TRIAL_COUNT_MIN_NUMBER) {
            throw new IllegalArgumentException(TRIAL_COUNT_NUMBER_ERROR);
        }
    }

}
