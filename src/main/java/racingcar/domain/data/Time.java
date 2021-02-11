package racingcar.domain.data;

import racingcar.domain.validation.TimeValidation;

public class Time {
    private final int value;

    public Time(final String value) {
        TimeValidation.validateTime(value);
        this.value = Integer.parseInt(value);
    }

    public boolean isOver(final int value) {
        return this.value == value;
    }
}
