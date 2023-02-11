package racingcar.domain.wrapper;

import static racingcar.domain.constant.RaceConstant.RACE_MIN_TRY_COUNT;
import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;
import static racingcar.enumType.ExceptionMessage.TYPE_MESSAGE;

public class RaceCount {

    private final int count;

    private RaceCount(final String tryCount) {
        int count = validateType(tryCount);
        this.count = validateRange(count);
    }

    public static RaceCount of(final String tryCount) {
        return new RaceCount(tryCount);
    }

    public int getCount() {
        return count;
    }

    private int validateType(final String tryCount) {
        int count;
        try {
            count = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "시도 횟수"));
        }
        return count;
    }

    private int validateRange(final int tryCount) {
        if (tryCount <= RACE_MIN_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), RACE_MIN_TRY_COUNT.getValue()));
        }
        return tryCount;
    }
}
