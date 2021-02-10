package racingcar.domain;

public class Lap {
    private static final int MINIMUM_LAP = 1;
    private static final String ERROR_MESSAGE_OF_NEGATIVE_NUMBER = "1 미만의 입력입니다.";
    private static final String ERROR_MESSAGE_OF_NOT_NUMBER = "숫자가 아닌 입력입니다.";

    private final int lap;

    public Lap(final String inputLap) {
        int numberLap = validateNumberLap(inputLap);
        this.lap = validatePositiveLap(numberLap);
    }

    private int validateNumberLap(final String inputLap) {
        try {
            return Integer.parseInt(inputLap);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_NOT_NUMBER);
        }
    }

    private int validatePositiveLap(final int numberLap) {
        if (numberLap < MINIMUM_LAP) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_NEGATIVE_NUMBER);
        }
        return numberLap;
    }

    public boolean isSameNumber(final int lapNumber) {
        return lap == lapNumber;
    }

    public int getLap() {
        return lap;
    }
}
