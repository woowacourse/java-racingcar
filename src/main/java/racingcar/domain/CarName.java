package racingcar.domain;

import racingcar.exception.carname.CarNameLengthOverException;
import racingcar.exception.carname.CarNameNotExistsException;
import racingcar.exception.carname.CarNameNullPointerException;
import racingcar.exception.carname.CarNameSpaceException;

public class CarName {
    private static int MAX_CAR_NAME_LENGTH = 5;
    private static String EMPTY_STRING = "";

    private final String carName;

    public CarName(String carName) {
        checkCarName(carName);
        this.carName = carName;
    }

    private static void checkCarName(String input) {
        checkCarNameNotNull(input);
        checkCarNameLength(input);
        checkCarNameExists(input);
        checkCarNameIsNotSpace(input);
    }

    private static void checkCarNameNotNull(String carName) {
        if (carName == null) {
            throw new CarNameNullPointerException();
        }
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameLengthOverException(carName.length());
        }
    }

    private static void checkCarNameExists(String carName) {
        if (carName.equals(EMPTY_STRING)) {
            throw new CarNameNotExistsException();
        }
    }

    private static void checkCarNameIsNotSpace(String carName) {
        if (carName.trim().equals(EMPTY_STRING)) {
            throw new CarNameSpaceException();
        }
    }

    public String getCarName() {
        return carName;
    }
}
