package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVING_BASELINE = 4;

    private final Racer racer;
    private final Position position;

    public Car(Racer racer) {
        this.racer = racer;
        this.position = new Position(0);
    }

    public void movePosition(int value) {
        if (value >= MOVING_BASELINE) {
            position.move();
        }
    }

    public boolean hasSamePositionWith(Car car) {
        return position.isSame(car.position);
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    public Racer getRacer() {
        return racer;
    }

    public Position getPosition() {
        return position;
    }
}