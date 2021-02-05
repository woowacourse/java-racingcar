package racingcar.domain;

public class Trial {
    private static final int MIN_TRIAL_COUNT = 1;
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String COUNT_ERR_MSG = ERROR_PREFIX + "시도 횟수는 1이상의 양수만 입력가능합니다.";
    private static final String NUMBER_ERR_MSG = ERROR_PREFIX + "시도 횟수는 숫자여야합니다.";
    private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";
    private int trial;

    public Trial(final String trial) {
        checkTrialValidation(trial);
        this.trial = Integer.parseInt(trial);
    }

    private void checkTrialValidation(final String trial) {
        isNumber(trial);
        isTrialMoreThan1(trial);
    }

    private void isNumber(final String trial) {
        if (!trial.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NUMBER_ERR_MSG);
        }
    }

    private void isTrialMoreThan1(final String trial) {
        if (Integer.parseInt(trial) < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException(COUNT_ERR_MSG);
        }
    }

    public int getTrial() {
        return trial;
    }
}
