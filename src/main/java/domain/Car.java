package domain;

public class Car {

    private final CarName carName;
    private final Position position;
    private final PowerGenerator powerGenerator;

    private Car(CarName carName) {
        this(carName, new Position());
    }

    private Car(CarName carName, Position position) {
        this(carName, position, new RandomPowerGenerator());
    }

    private Car(CarName carName, Position position, PowerGenerator powerGenerator) {
        this.carName = carName;
        this.position = position;
        this.powerGenerator = powerGenerator;
    }

    public static Car from(String name) {
        return new Car(new CarName(name));
    }

    static Car of(String name, Integer position) {
        return new Car(new CarName(name), new Position(position));
    }

    static Car of(String name, Integer position, PowerGenerator powerGenerator) {
        return new Car(new CarName(name), new Position(position), powerGenerator);
    }

    public void tryMove() {
        moveByPower(powerGenerator.generate());
    }

    void moveByPower(Power power) {
        if (power.isSufficientPower()) {
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
