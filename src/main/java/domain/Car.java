package domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(boolean movable) {
        if (movable) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
