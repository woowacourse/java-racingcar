package racingcar.domain.car;

import racingcar.domain.car.move.MovingStrategy;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Position position;
    private final MovingStrategy movingStrategy;

    public Car(final String name, final MovingStrategy movingStrategy) {
        this.name = new CarName(name);
        this.position = new Position(0);
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.canMove()) {
            position.forward();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public int compareTo(final Car o) {
        return this.position.compareTo(o.position);
    }
}