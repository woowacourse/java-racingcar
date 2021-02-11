package racing.domain;

import racing.domain.name.CarName;
import racing.domain.number.Position;

public class Car {
    private static final int MINIMUM_MOVE_NUMBER = 4;

    private final CarName name;
    private final Position position;

    public Car(final CarName name) {
        this.name = name;
        this.position = Position.of();
    }

    public boolean move(final int randomNumber) {
        if (randomNumber >= MINIMUM_MOVE_NUMBER) {
            position.add();
            return true;
        }
        return false;
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isSamePosition(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public String getName() {
        return name.getName();
    }
}

