package racingcar.domain;

import static racingcar.enumType.CarConstant.NAME_MAX_LENGTH;
import static racingcar.enumType.ExceptionMessage.BLANK_MESSAGE;
import static racingcar.enumType.ExceptionMessage.LENGTH_MESSAGE;

public class Car {
    private final String name;

    private final StringBuilder drivingMark;

    private Car(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name =  name;
        this.drivingMark = new StringBuilder();
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH.getValue()) {
            throw new IllegalArgumentException(LENGTH_MESSAGE.getValue());
        }
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE.getValue());
        }
    }

    public void move() {
        drivingMark.append("-");
    }

    @Override
    public String toString() {
        return name + " : " + drivingMark;
    }

    public static Car of(final String name) {
        return new Car(name);
    }
}
