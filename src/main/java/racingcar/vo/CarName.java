package racingcar.vo;

import racingcar.view.ErrorMessage;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_EMPTY.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName) object;
        return carName.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
