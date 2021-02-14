package racingcar.domain.car;

import racingcar.domain.car.strategy.MoveStrategy;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(new Name(name), new Position(START_POSITION));
    }

    public Car(final String name, final int position) {
        this(new Name(name), new Position(position));
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(final Position position) {
        return this.position.equals(position);
    }

    public void goForwardRandomly(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            goForward();
        }
    }

    private void goForward() {
        this.position = position.goForward();
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
