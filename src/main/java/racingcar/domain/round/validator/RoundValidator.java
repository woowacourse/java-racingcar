package racingcar.domain.round.validator;

import racingcar.domain.round.condition.RoundCount;
import racingcar.exception.WrongArgumentException;
import racingcar.exception.status.round.RoundCountExceptionStatus;

public class RoundValidator {

    public static final RoundValidator ROUND_VALIDATOR = new RoundValidator();

    private RoundValidator() {
    }

    public static void validateCount(final int count) {
        ROUND_VALIDATOR.validateCountPositive(count);
    }

    private void validateCountPositive(final int count) {
        if (RoundCount.isTooSmall(count)) {
            throw new WrongArgumentException(RoundCountExceptionStatus.ROUND_IS_NOT_POSITIVE);
        }
    }

}
