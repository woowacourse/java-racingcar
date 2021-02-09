package racingcar.domain;

public class Car {
    private static final int MOVABLE_VALUE = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = Position.ZERO;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position = position.nextPosition();
        }
    }

    public boolean isSamePosition(Position thatPosition) {
        return this.position.equals(thatPosition);
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_VALUE;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
