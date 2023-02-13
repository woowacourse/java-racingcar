package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int MOVE_LOWER_BOUND = 4;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(final int value) {
        if (MOVE_LOWER_BOUND <= value) {
            position.increase();
        }
    }

    public boolean isSamePosition(final Car car) {
        return this.position.equals(car.position);
    }

    @Override
    public int compareTo(final Car other) {
        return this.position.compareTo(other.position);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
