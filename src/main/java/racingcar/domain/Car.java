package racingcar.domain;

import racingcar.dto.RacingCarStatusResponse;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public RacingCarStatusResponse getStatus() {
        return new RacingCarStatusResponse(name, position);
    }

    public void move() {
        position++;
    }
}
