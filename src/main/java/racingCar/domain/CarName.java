package racingCar.domain;

public class CarName {
    private static final int NAME_MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        this.carName = carName;
        validateLength(carName);
    }

    public String getCarName() {
        return carName;
    }

    private void validateLength(String carName) {
        if (carName.isBlank() || carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
