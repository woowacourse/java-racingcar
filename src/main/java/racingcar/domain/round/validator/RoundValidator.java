package racingcar.domain.round.validator;

import racingcar.domain.round.condition.RoundCount;
import racingcar.exception.round.RoundCountExceptionStatus;
import racingcar.exception.round.WrongRoundCountException;

public class RoundValidator {

    public static final RoundValidator ROUND_VALIDATOR = new RoundValidator();

    private RoundValidator() {
    }

    public static void validateCount(final int count) {
        ROUND_VALIDATOR.validateCountPositive(count);
    }

    private void validateCountPositive(final int count) {
        if (RoundCount.isTooSmall(count)) {
            throw new WrongRoundCountException(RoundCountExceptionStatus.ROUND_IS_NOT_POSITIVE);
        }
    }

}
