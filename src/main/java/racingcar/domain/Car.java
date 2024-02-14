package racingcar.domain;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int forward;

    Car(String name) {
        validate(name);
        this.name = name;
        forward = 0;
    }

    private void validate(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    String getName() {
        return name;
    }

    int getForward() {
        return forward;
    }
}
