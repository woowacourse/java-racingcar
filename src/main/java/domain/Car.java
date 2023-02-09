package domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
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
