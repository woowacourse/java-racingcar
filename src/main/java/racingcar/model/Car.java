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

    public boolean isSamePosition(Car car) {
        return position.equals(car.getPosition());
    }

    @Override
    public int compareTo(Car o) {
        if (this.position.isSmallerThan(o.position)) {
            return -1;
        } else if (this.position.equals(o.position)) {
            return 0;
        }
        return 1;
    }
}
