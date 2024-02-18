package domain;

public class Car {

    private final CarName carName;
    private final Position position;
    private final RandomPowerGenerator randomPowerGenerator;

    private Car(CarName carName) {
        this(carName, new Position());
    }

    private Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
        this.randomPowerGenerator = new RandomPowerGenerator();
    }

    public static Car from(String name) {
        return new Car(new CarName(name));
    }

    static Car of(String name, Integer position) {
        return new Car(new CarName(name), new Position(position));
    }

    public void tryMove() {
        if (randomPowerGenerator.generate().isSufficientPower()) {
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
