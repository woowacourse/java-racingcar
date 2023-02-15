package domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(Name name) {
        this(name, Position.create());
    }

    public Car(Car car) {
        this.name = new Name(car.getName());
        this.position = new Position(car.getPosition());
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
