package domain;

public class Car {
    private final String carName;

    private Car(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    private void validate(String carName) {
        validateCarNameLength(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
