package racingcar.domain;

import static java.text.MessageFormat.format;

public class Count {

    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 100;
    private static final String INVALID_COUNT_MESSAGE =
            "입력된 횟수[{0}]: 횟수는 " + MINIMUM_COUNT + "이상, " + MAXIMUM_COUNT + "이하의 정수만 가능합니다.";

    private int value;

    public Count(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int number) {
        if (isZeroOrNegative(number) || isOverMaximum(number)) {
            throw new IllegalArgumentException(format(INVALID_COUNT_MESSAGE, number));
        }
    }

    private boolean isZeroOrNegative(final int number) {
        return number < MINIMUM_COUNT;
    }

    private boolean isOverMaximum(final int number) {
        return MAXIMUM_COUNT < number;
    }

    public void decrease() {
        value--;
    }

    public boolean isPlayable() {
        return value >= MINIMUM_COUNT;
    }
}
