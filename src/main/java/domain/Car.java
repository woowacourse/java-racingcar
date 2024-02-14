package domain;

public class Car {
    private final String carName;
    private final PowerGenerator powerGenerator = new PowerGenerator(new RandomNumberGenerator());
    private Integer position = 0;

    private Car(String carName) {
        validate(carName);
        this.carName = carName;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void tryMove() {
        if (powerGenerator.generatePower().isSufficientPower()) {
            move();
        }
    }

    public void move() {
        position++;
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
