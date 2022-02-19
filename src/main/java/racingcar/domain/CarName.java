package racingcar.domain;

import racingcar.validator.exception.carname.CarNameLengthOverException;
import racingcar.validator.exception.carname.CarNameNotFoundException;
import racingcar.validator.exception.carname.CarNameSpaceException;

public class CarName {
    private static int MAX_CAR_NAME_LENGTH = 5;
    private static String EMPTY_STRING = "";

    private final String carName;

    public CarName(String carName) {
        checkCarName(carName);
        this.carName = carName;
    }

    private static void checkCarName(String input) {
            checkCarNameLength(input);
            checkCarNameNotFound(input);
            checkCarNameIsSpace(input);
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameLengthOverException(carName.length());
        }
    }

    private static void checkCarNameNotFound(String carName) {
        if (carName.equals(EMPTY_STRING)) {
            throw new CarNameNotFoundException();
        }
    }

    private static void checkCarNameIsSpace(String carName) {
        if (carName.trim().equals(EMPTY_STRING)) {
            throw new CarNameSpaceException();
        }
    }

    public String getCarName() {
        return carName;
    }
}
