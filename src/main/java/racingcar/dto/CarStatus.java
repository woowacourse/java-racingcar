package racingcar.dto;

import racingcar.domain.Position;

public class CarStatus {
    private final String name;
    private final int currentPosition;

    public CarStatus(String name, Position currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
