package racingcar.domain;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final CarName carName;
    private final Position currentPosition;

    public Car(final String name) {
        this.carName = new CarName(name);
        this.currentPosition = new Position();
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void move(final NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (isMovable(number)) {
            currentPosition.move();
        }
    }

    public boolean isSamePosition(final Position targetPosition) {
        return currentPosition.equals(targetPosition);
    }

    private boolean isMovable(final int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}
