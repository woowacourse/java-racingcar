package racingcar.domain;

import racingcar.dto.RacingStatusDto;

public class Car {

    private final CarName carName;
    private Status status;

    public Car(String carName) {
        this.carName = new CarName(carName);
        status = Status.INIT();
    }

    public void move() {
        status = status.next();
    }

    public RacingStatusDto toDto() {
        return new RacingStatusDto(status.getMoveCount(), carName.getName());
    }

    public int getStatus() {
        return status.getMoveCount();
    }

    public String getCarName() {
        return carName.getName();
    }
}
