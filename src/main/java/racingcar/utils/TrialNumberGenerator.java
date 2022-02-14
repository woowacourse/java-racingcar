package racingcar.utils;

public class TrialNumberGenerator {
    public static int generateTrialNumber(String input) {
        TrialNumberValidator.validate(input);
        return Integer.parseInt(input);
    }
}
