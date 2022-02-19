package racingcar.utils;

import racingcar.validator.RoundNumberValidator;

public class RoundNumberGenerator {
    public static int toIntWithValidate(final String roundNumberString) {
        RoundNumberValidator.validate(roundNumberString);
        return Integer.parseInt(roundNumberString);
    }
}
