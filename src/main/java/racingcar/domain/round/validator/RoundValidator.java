package racingcar.domain.round.validator;

import racingcar.domain.round.condition.RoundCountRange;
import racingcar.exception.round.RoundNotPositiveException;

public class RoundValidator {

    public static final RoundValidator ROUND_VALIDATOR = new RoundValidator();

    private RoundValidator() { }

    public static void validateCount(int count) {
        ROUND_VALIDATOR.validateCountPositive(count);
    }

    void validateCountPositive(int count) {
        if (RoundCountRange.isTooSmall(count)) {
            throw new RoundNotPositiveException();
        }
    }

}
