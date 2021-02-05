package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVING_BASELINE = 4;

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    public String getName() {
        return this.name.getName();
    }

    public void movePosition(int value) {
        if (value >= MOVING_BASELINE) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean hasSamePositionWith(Car car) {
        return position.isSame(car.getPosition());
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.position.getPosition(), car.position.getPosition());
    }
}