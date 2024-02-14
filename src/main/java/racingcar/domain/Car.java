package racingcar.domain;

import static racingcar.constant.ExceptionMessage.INVALID_CAR_NAME;

public class Car {

    private final String name;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw INVALID_CAR_NAME.getException();
        }
    }
}
