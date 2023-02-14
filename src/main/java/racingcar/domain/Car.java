package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {

    private static final int MOVING_CONDITION = 4;

    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MovingStrategy strategy) {
        if (strategy.move() >= MOVING_CONDITION) {
            position.updatePosition();
        }
    }

    public int findGreaterPosition(int maxPosition) {
        return position.comparePosition(maxPosition);
    }

    public boolean isWinner(int maxPosition) {
        return position.isSamePosition(maxPosition);
    }

    public String getResult(String positionSign) {
        return name.getName() + " : " + positionSign.repeat(Math.max(0, position.getPosition()));
    }

    public String getName() {
        return name.getName();
    }
}
