package racingcar.utils;

public class TrialNumberGenerator {
    public static int generateTrialNumber(String input) {
        TrialNumberValidator.isEmpty(input);
        TrialNumberValidator.isNotInteger(input);

        int trialNumber = Integer.parseInt(input);
        TrialNumberValidator.isNotPositive(trialNumber);

        return trialNumber;
    }
}
