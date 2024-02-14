package domain;

public class Car {
    private final String carName;
    private Integer position;
    private final PowerGenerator powerGenerator = new PowerGenerator(new RandomNumberGenerator());

    private Car(String carName, int position) {
        validate(carName);
        this.carName = carName;
        this.position = position;
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public Integer getPosition() {
        return this.position;
    }

    public void tryMove() {
        if (powerGenerator.generatePower().isSufficientPower()) {
            move();
        }
    }

    private void move() {
        position++;
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
