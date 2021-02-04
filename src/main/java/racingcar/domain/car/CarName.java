package racingcar.domain.car;

import racingcar.exception.CarNameBlankOrEmptyException;
import racingcar.exception.CarNameLengthException;

public class CarName {
    private static final int CAR_NAME_LENGTH_THRESHOLD = 5;

    private String name;

    public CarName(String name) {
        validateCarNameLength(name);
        validateCarNameBlankOrEmpty(name);
        this.name = name;
    }

    private void validateCarNameLength(String name) {
        if(name.length() > CAR_NAME_LENGTH_THRESHOLD) {
            throw new CarNameLengthException();
        }
    }

    private void validateCarNameBlankOrEmpty(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new CarNameBlankOrEmptyException();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof CarName)) {
            return false;
        }

        return name.equals(((CarName) o).name);
    }
}
