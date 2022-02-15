package racingcar.domain.round.validator;

import racingcar.domain.round.condition.RoundCountRange;
import racingcar.exception.round.RoundNotPositiveException;

public class RoundValidator {

    public static RoundValidator instance = new RoundValidator();

    public static void validateCount(int count) {
        instance.validateCountPositive(count);
    }

    void validateCountPositive(int count) {
        if (RoundCountRange.isTooSmall(count)) {
            throw new RoundNotPositiveException();
        }
    }

}
