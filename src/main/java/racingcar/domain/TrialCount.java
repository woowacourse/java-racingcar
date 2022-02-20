package racingcar.domain;

public class TrialCount {

    private static final int MIN_COUNT = 0;
    private static final String ERROR_NUMBER_OVER_ONE = "횟수는 1 이상이어야 합니다.";
    private static final String ERROR_NUMBER_NOT_DIGIT = "횟수는 숫자로 입력해야 합니다.";

    private final int trialCount;

    public TrialCount(final String trialCount) {
        this.trialCount = toInt(trialCount);
    }

    private int toInt(final String text) {
        try {
            int parseInt = Integer.parseInt(text);

            checkPositiveNumber(parseInt);
            return parseInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_NOT_DIGIT);
        }
    }

    private void checkPositiveNumber(final int parseInt) {
        if (parseInt <= MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_NUMBER_OVER_ONE);
        }
    }

    public boolean canContinue(final int count) {
        return this.trialCount > count;
    }
}
