package racingcar.domain;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final CarName carName;
    private final Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void moveByRandomNumber(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.moveForward();
        }
    }

    public CarName getName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
