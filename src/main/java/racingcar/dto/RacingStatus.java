package racingcar.dto;

import racingcar.domain.Car;

public class RacingStatus {
    private final String name;
    private final int position;

    public RacingStatus(final Car car) {
        this.name = car.getName().value();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
