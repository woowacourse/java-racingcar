package racingcar.utils.generator;

import racingcar.utils.validator.TrialNumberValidator;

public class TrialNumberGenerator {
    public static int generateTrialNumber(String input) {
        TrialNumberValidator.validate(input);
        return Integer.parseInt(input);
    }
}
