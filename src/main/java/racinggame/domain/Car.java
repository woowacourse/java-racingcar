package racinggame.domain;

import java.util.Objects;

public class Car {

    private static final int INITIAL_POSITION = 0;

    private final Name name;
    private Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car createDefault(String name) {
        return new Car(new Name(name), new Position(INITIAL_POSITION));
    }

    public boolean isSamePosition(int target) {
        return position.getPosition() == target;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.isMovable()) {
            position = position.increase();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
