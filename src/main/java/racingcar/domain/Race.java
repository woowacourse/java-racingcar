package racingcar.domain;

import racingcar.enumType.ExceptionMessage;

public class Race {
    private final int tryCount;

    private Race(String tryCount) {
        int count = validateType(tryCount);
        this.tryCount = validateRange(count);
    }

    public static Race of(String tryCount) {
        return new Race(tryCount);
    }

    private int validateType(String tryCount) {
        int count;
        try {
            count = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ExceptionMessage.TYPE_MESSAGE.getValue(), "시도 횟수"));
        }
        return count;
    }

    private int validateRange(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_MESSAGE.getValue());
        }
        return tryCount;
    }
}
