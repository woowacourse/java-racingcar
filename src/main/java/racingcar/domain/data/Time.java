package racingcar.domain.data;

import racingcar.domain.validation.TimeValidation;

public class Time {
    private static int value;

    public Time(String value) {
        TimeValidation.validateTime(value);
        this.value = Integer.parseInt(value);
    }

    public boolean isOver(int value) {
        return this.value == value;
    }
}
