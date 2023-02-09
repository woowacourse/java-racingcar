package racingcar.domain;

import static racingcar.enumType.DomainConstant.RACE_MIN_TRY_COUNT;
import static racingcar.enumType.ExceptionMessage.RANGE_MESSAGE;
import static racingcar.enumType.ExceptionMessage.TYPE_MESSAGE;

public class Race {

    private final int tryCount;

    private Race(String tryCount) {
        int count = validateType(tryCount);
        this.tryCount = validateRange(count);
    }

    public static Race of(String tryCount) {
        return new Race(tryCount);
    }

    public String start(Cars cars) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.tryCount; i++) {
            result.append(cars.race()).append("\n");
        }
        return result.toString();
    }

    private int validateType(String tryCount) {
        int count;
        try {
            count = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "시도 횟수"));
        }
        return count;
    }

    private int validateRange(int tryCount) {
        if (tryCount <= RACE_MIN_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(RANGE_MESSAGE.getValue());
        }
        return tryCount;
    }
}
