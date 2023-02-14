package racingcar.domain.wrapper;

import static racingcar.domain.constant.RaceConstant.RACE_MIN_TRY_COUNT;
import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;
import static racingcar.enumType.ExceptionMessage.TYPE_MESSAGE;

public class RaceCount {

    private final int count;

    private RaceCount(final String raceCount) {
        int count = validateType(raceCount);
        this.count = validateRange(count);
    }

    public static RaceCount create(final String raceCount) {
        return new RaceCount(raceCount);
    }

    private int validateType(final String raceCount) {
        int count;
        try {
            count = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "시도 횟수"));
        }
        return count;
    }

    private int validateRange(final int raceCount) {
        if (raceCount <= RACE_MIN_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), RACE_MIN_TRY_COUNT.getValue()));
        }
        return raceCount;
    }

    public int getCount() {
        return count;
    }
}
