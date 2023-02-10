package racingcar.validator;

import java.util.regex.Pattern;

public class TrialTimesValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d)+");
    private static final int TRIAL_MAX_TIMES = 100;
    private static final int TRIAL_MIN_TIMES = 1;
    private static final String INVALID_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    private static final String INVALID_RANGE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 100 이하여야 합니다.";


    public static void validate(String trialTimes) {
        validateNumber(trialTimes);
        validateRange(trialTimes);
    }

    private static void validateNumber(String trialTimes) {
        if (!NUMBER_PATTERN.matcher(trialTimes).matches()) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateRange(String trialTimes) {
        int trialTimesNumber = Integer.parseInt(trialTimes);

        if (trialTimesNumber < TRIAL_MIN_TIMES || trialTimesNumber > TRIAL_MAX_TIMES) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR_MESSAGE);
        }
    }
}
