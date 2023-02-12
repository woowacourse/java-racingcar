package domain;

public class CarName {

    private static final String CAR_NAME_LENGTH_EXCEED = "[ERROR] 자동차 이름의 길이는 1자 이상, 5자 이하여야 합니다.";
    private static final String CAR_NAME_EMPTY = "[ERROR] 자동차의 이름은 공백이면 안됩니다.";

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
            throw new IllegalArgumentException(CAR_NAME_EMPTY);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEED);
        }
    }

    public String get() {
        return carName;
    }
}
