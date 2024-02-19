package racingcar.domain;

import racingcar.exception.InvalidRoundFormatException;
import racingcar.exception.InvalidRoundRangeException;

public class Round {

    private static final int MIN_ROUND_COUNT = 1;

    private int count;

    public Round(String count) {
        this.count = tryConvertRoundCount(count);
        validateCountRange();
    }

    private void validateCountRange() {
        if (count < MIN_ROUND_COUNT) {
            throw new InvalidRoundRangeException();
        }
    }

    private int tryConvertRoundCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch(NumberFormatException e) {
            throw new InvalidRoundFormatException();
        }
    }

    public boolean isRemain() {
        return count > 0;
    }

    public void decreaseCount() {
        count--;
    }
}
