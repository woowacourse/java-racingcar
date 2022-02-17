package racingcar.model;

public class Car implements Comparable<Car> {

    private final Name name;
    private final Position position;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = Position.createStartPosition();
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

    public boolean isSamePosition(Car maxPositionCar) {
        return position.equals(maxPositionCar.getPosition());
    }

    @Override
    public int compareTo(Car o) {
        if (this.position.equals(o.position)) {
            return 0;
        }

        if (this.position.isSmallerThan(o.position)) {
            return -1;
        }

        return 1;
    }
}
