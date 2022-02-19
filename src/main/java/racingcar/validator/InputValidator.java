package racingcar.validator;

import racingcar.validator.exception.TrialCountNotNumericException;
import racingcar.validator.exception.TrialCountNotPositiveException;

public class InputValidator {

    public static void checkTrialCountLine(String line) {
        checkTrialCountNumeric(line);
        checkTrialCountPositive(line);
    }

    private static void checkTrialCountNumeric(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new TrialCountNotNumericException();
        }
    }

    private static void checkTrialCountPositive(String line) {
        if (Integer.parseInt(line) <= 0) {
            throw new TrialCountNotPositiveException();
        }
    }
}
