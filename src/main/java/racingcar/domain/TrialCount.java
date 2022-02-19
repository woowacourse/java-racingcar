package racingcar.domain;

import racingcar.validator.exception.TrialCountNotNumericException;
import racingcar.validator.exception.TrialCountNotPositiveException;

public class TrialCount {

    private int trialCount;

    private TrialCount(int trialCount) {
        this.trialCount = trialCount;
    }

    public static TrialCount from(String trialCountLine) {
        checkTrialCountLine(trialCountLine);
        return new TrialCount(Integer.parseInt(trialCountLine));
    }

    private static void checkTrialCountLine(String line) {
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

    public int toInt() {
        return trialCount;
    }
}
