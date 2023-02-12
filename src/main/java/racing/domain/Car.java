package racing.domain;

public class Car {

    private static final int INITIAL_VALUE = 0;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INITIAL_VALUE);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            this.position = position.increase();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
