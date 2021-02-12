package racingcar.domain.car;

import racingcar.domain.car.strategy.RandomMoveStrategy;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private Position position;
    private RandomMoveStrategy randomMoveStrategy;

    public Car(final String name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
        this.randomMoveStrategy = new RandomMoveStrategy();
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }

    public void goForwardRandomly() {
        if (randomMoveStrategy.isMovable()) {
            this.position = position.goForward();
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
