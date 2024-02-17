package domain;

public class Car {

    private final CarName carName;
    private final Position position;
    private final PowerGenerator powerGenerator;

    private Car(String carName) {
        this(new CarName(carName), new Position());
    }

    Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
        this.powerGenerator = new PowerGenerator();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void tryMove() {
        if (powerGenerator.generate().isSufficientPower()) {
            position.move();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Integer getPosition() {
        return position.getPosition();
    }
}
