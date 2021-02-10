package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVING_BASELINE = 4;
    private static final int START_POSITION = 0;

    private final Racer racer;
    private Position position;

    public Car(Racer racer) {
        this.racer = racer;
        this.position = new Position(START_POSITION);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveValue() >= MOVING_BASELINE) {
            this.position = position.move();
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