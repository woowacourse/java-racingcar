package racingcar.model;

import racingcar.message.ErrorMessage;

public class CarName {

    private static final int MIN_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.get());
        }

        if (name.trim().length() > MIN_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.get());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
