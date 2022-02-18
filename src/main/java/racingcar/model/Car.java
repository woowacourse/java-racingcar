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

    public boolean isSamePosition(Car car) {
        return position.equals(car.getPosition());
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.getPosition());
    }
}
