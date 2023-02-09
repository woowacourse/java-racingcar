package racingcar.domain;

import static racingcar.validator.Validator.*;

import racingcar.dto.RacingCarStatusResponse;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name) {
        validateEmptyCarName(name);
        validateCarNameLength(name);
        this.name = name;
        this.position = new Position(0);
    }

    public RacingCarStatusResponse getStatus() {
        return new RacingCarStatusResponse(name, position.getValue());
    }

    public void move() {
        position.forward();
    }

    public Position getMovedLength() {
        return position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }
}
