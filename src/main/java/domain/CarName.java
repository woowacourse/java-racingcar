package domain;

import exception.CarNameBlankException;
import exception.CarNameLengthException;

public class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        validateCarNameIsNotEmpty(carName);
        validateCarNameLength(carName);
    }

    private void validateCarNameIsNotEmpty(String carName) {
        if (carName.isBlank()) {
            throw new CarNameBlankException();
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameLengthException();
        }
    }

    public String getCarName() {
        return carName;
    }
}
