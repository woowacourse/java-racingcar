package racingcar.domain;

public class Car {
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final CarName name;
    private final Position currentPosition;

    public Car(String name, int startPoint) {
        this.name = new CarName(name);
        this.currentPosition = new Position(startPoint);
    }

    public void move(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();

        if (isMovable(randomNumber)) {
            currentPosition.move();
        }
    }

    public int compareTo(Car other) {
        return this.currentPosition.getPosition() - other.currentPosition.getPosition();
    }

    public boolean isSamePosition(Car target) {
        return currentPosition.equals(target.currentPosition);
    }

    private boolean isMovable(int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }

    public String getName() {
        return name.getName();
    }

    public int getCurrentPosition() {
        return currentPosition.getPosition();
    }

}
