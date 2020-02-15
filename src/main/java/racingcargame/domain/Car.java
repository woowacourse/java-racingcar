package racingcargame.domain;

public class Car {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INITIAL_POSITION);
    }

    public void move(int value) {
        if (value >= FORWARD_THRESHOLD) {
            position.move();
        }
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
