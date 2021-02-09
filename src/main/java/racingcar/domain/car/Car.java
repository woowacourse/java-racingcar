package racingcar.domain.car;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(Position position) {
        return this.position == position;
    }

    public void goForward() {
        position.goForward();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
