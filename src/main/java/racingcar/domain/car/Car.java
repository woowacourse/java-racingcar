package racingcar.domain.car;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public void goForward() {
        this.position = position.goForward();
    }

    public String getValueOfName() {
        return name.getValue();
    }

    public int getValueOfPosition() {
        return position.getValue();
    }
}
