package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVING_BASELINE = 4;

    private final Racer racer;
    private final Position position;

    public Car(Racer racer) {
        this.racer = racer;
        this.position = new Position(0);
    }

    public Racer getRacer() {
        return racer;
    }

    public void movePosition(int value) {
        if (value >= MOVING_BASELINE) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Position getPosition(Car car) {
        return car.position;
    }

    public boolean hasSamePositionWith(Car car) {
        return position.isSame(getPosition(car));
    }

    @Override
    public int compareTo(Car car) {
        return position.comparePosition(getPosition(car));
    }
}