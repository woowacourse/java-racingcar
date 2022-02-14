package racingcar.domain;

import racingcar.domain.movestrategy.MoveStrategy;

public class Car {

    private final MoveStrategy strategy;
    private final Name name;
    private int position;

    public Car(final String name, final MoveStrategy strategy) {
        this.strategy = strategy;
        this.name = new Name(name);
        position = 0;
    }

    public Car(final String name, final MoveStrategy strategy, final int position) {
        this.strategy = strategy;
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        if (strategy.canMove()) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "Car("
                + "name = " + name
                + ", position = " + position
                + ")";
    }
}
