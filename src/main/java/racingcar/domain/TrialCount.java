package racingcar.domain;

import racingcar.exception.trialcount.TrialCountNotNumericException;
import racingcar.exception.trialcount.TrialCountNotPositiveException;
import racingcar.exception.trialcount.TrialCountNullPointerException;

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
        checkTrialCountNotNull(line);
        checkTrialCountNumeric(line);
        checkTrialCountPositive(line);
    }

    private static void checkTrialCountNotNull(String line) {
        if (line == null) {
            throw new TrialCountNullPointerException();
        }
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

    public void consume() {
        trialCount--;
    }

    public boolean isEmpty() {
        return trialCount == 0;
    }
}
