package racingcar.domain;

import racingcar.dto.RacingCarStatusResponse;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public RacingCarStatusResponse getStatus() {
        return new RacingCarStatusResponse(name.getName(), position.getValue());
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
