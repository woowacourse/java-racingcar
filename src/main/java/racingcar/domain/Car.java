package racingcar.domain;

import static racingcar.domain.Position.ZERO;

public class Car {

    private static final int MOVE_POINT_NUMBER = 4;
    private final Name name;
    private Position position;

    public Car(Name name) {
        this(name, ZERO);
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public int move(final int randomNumber) {
        if (checkMoveCondition(randomNumber)) {
            position = position.move();
        }
        return position.getValue();
    }

    private boolean checkMoveCondition(final int randomNumber) {
        return (randomNumber >= MOVE_POINT_NUMBER);
    }

    public boolean isWinner(final int maxPosition) {
        return position.isSamePosition(maxPosition);
    }

    public String getName() {
        return this.name.getValue();
    }

    public int getDistance() {
        return position.getValue();
    }

}
