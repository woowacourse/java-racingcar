package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move() {
        position.forward();
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Position getMovedLength() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
