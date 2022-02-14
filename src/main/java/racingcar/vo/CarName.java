package racingcar.vo;

import racingcar.view.ErrorMessage;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validEmpty(name);
        validLength(name);
        this.name = name;
    }

    public String get() {
        return name;
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

    private void validEmpty(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_EMPTY.toString());
        }
    }

    private void validLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_TOO_LONG.toString());
        }
    }
}
