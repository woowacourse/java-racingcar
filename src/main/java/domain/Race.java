package domain;

import validation.CountValidator;
import validation.ValidateResult;
import validation.exception.InvalidCountException;
import validation.exception.NotNumberException;

public class Race {

    private final int totalCount;
    private int currentCount = 0;

    public Race(final String totalCount) {
        ValidateResult validateResult = CountValidator.validate(totalCount);
        if (validateResult == ValidateResult.FAIL_NOT_A_NUMBER) {
            throw new NotNumberException();
        }
        if (validateResult == ValidateResult.FAIL_INVALID_COUNT) {
            throw new InvalidCountException();
        }
        this.totalCount = Integer.parseInt(totalCount);
    }

    public void addCount() {
        currentCount += 1;
    }

    public boolean isFinished() {
        return totalCount == currentCount;
    }
}
