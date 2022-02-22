package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String nameString) {
        this.name = new Name(nameString);
        this.position = new Position();
    }

    public void go(MoveStrategy strategy) {
        position.move(strategy.move());
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInt();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
