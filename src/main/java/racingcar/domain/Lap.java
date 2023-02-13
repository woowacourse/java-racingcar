package racingcar.domain;

import static racingcar.message.ErrorMessage.LAP_RANGE_ERROR_MESSAGE;

public class Lap {
    private final int totalLap;
    private int countTryLap;

    public Lap(int totalLap) {
        validateRange(totalLap);
        this.totalLap = totalLap;
        this.countTryLap = 0;
    }

    public void run() {
        this.countTryLap = this.countTryLap + 1;
    }

    public boolean isNotSame() {
        return countTryLap == totalLap;
    }

    public int getCountTryLap() {
        return this.countTryLap;
    }

    private void validateRange(int totalLap) {
        if (totalLap < 0) {
            throw new IllegalArgumentException(LAP_RANGE_ERROR_MESSAGE);
        }
    }
}
