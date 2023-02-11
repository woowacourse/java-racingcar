package racingcar.domain;

import racingcar.domain.vo.CarStatus;

import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class Car {

    public static final int START_POSITION = 1;
    private static final int CAR_MOVE_STANDARD = 4;
    public static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private int position;

    private Car(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name.trim();
        this.position = START_POSITION;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move(final int moveConditionValue) {
        if (moveConditionValue >= CAR_MOVE_STANDARD) {
            position++;
        }
    }

    public CarStatus getCarStatus() {
        return CarStatus.of(name, position);
    }

    private void validateNameLength(final String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    private void validateNameBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

}
