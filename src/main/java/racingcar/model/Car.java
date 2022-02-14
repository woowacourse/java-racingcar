package racingcar.model;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = new Position();
    }

    public void move(boolean movable) {
        if (movable) {
            this.position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return this.name;
    }

    public boolean isMaxPosition(Position maxPosition) {
        return position.equals(maxPosition);
    }
}
