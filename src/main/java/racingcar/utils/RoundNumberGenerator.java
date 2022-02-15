package racingcar.utils;

import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarOutput;
import racingcar.validator.RoundNumberValidator;

public class RoundNumberGenerator {
    public static int roundInput() {
        String roundNumberString = RacingCarInput.userRoundInput();
        try {
            return toIntWithValidate(roundNumberString);
        } catch (IllegalArgumentException e) {
            RacingCarOutput.printErrorMessage(e.getMessage());
            return roundInput();
        }
    }

    private static int toIntWithValidate(final String roundNumberString) {
        RoundNumberValidator.validate(roundNumberString);
        return Integer.parseInt(roundNumberString);
    }
}
