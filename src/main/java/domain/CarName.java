package domain;

public class CarName {

    private final String carName;

    private CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    private void validate(String carName) {
        validateLength(carName);
    }

    private void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getCarName() {
        return carName;
    }
}
