package racingcar.model;

public class Car {

    private static final int MINIMUM_STEP_FORWARD_STANDARD = 4;
    private static final int DEFAULT_POSITION = 0;

    private final CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position(DEFAULT_POSITION);
    }

    Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Position move(int number) {
        if (number >= MINIMUM_STEP_FORWARD_STANDARD) {
            position = position.move();
        }
        return position;
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
