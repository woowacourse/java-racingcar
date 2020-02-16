package racingcargame.domain;

public class Car {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;

    private Name name;
    private Position position;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("null값을 입력하지 마시오.");
        }
        this.name = name;
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
