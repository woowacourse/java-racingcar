package domain;

import validation.CountValidator;
import validation.ErrorMessages;
import validation.ValidateResult;

public class Race {

    private final int TOTAL_COUNT;
    private int currentCount = 0;

    public Race(final String totalCount) {
        ValidateResult validateResult = CountValidator.validate(totalCount);
        if (validateResult == ValidateResult.FAIL_NOT_A_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_NUMBER.getMessage());
        }
        if (validateResult == ValidateResult.FAIL_INVALID_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_COUNT.getMessage());
        }
        this.TOTAL_COUNT = Integer.parseInt(totalCount);
    }

    public void addCount() {
        currentCount += 1;
    }

    public boolean isFinished() {
        return TOTAL_COUNT == currentCount;
    }
}
