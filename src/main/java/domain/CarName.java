package domain;

import validation.ErrorMessage;

import java.util.Objects;

public class CarName {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name.replaceAll(SPACE, NO_SPACE);
    }

    private void validate(String name) {
        if (isEmptyOrBlank(name) || isWrongSizeName(name)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_CAR_NAME.getMessage());
        }
    }

    private boolean isEmptyOrBlank(String name) {
        return name.isBlank();
    }

    private boolean isWrongSizeName(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(getName(), carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
