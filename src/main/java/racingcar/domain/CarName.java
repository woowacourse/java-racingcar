package racingcar.domain;

import racingcar.utils.ExceptionMessage;

public class CarName {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;
    private final String value;

    public CarName(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if(value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(ExceptionMessage.LONGER_THAN_FIVE_CAR_NAME);
        }
    }
}
