package domain;

import dto.RacingStatusDto;

public class Car {

    private final CarName carName;
    private int status;

    public Car(String carName) {
        this.carName = new CarName(carName);
        status = 0;
    }

    public void move() {
        status++;
    }

    public RacingStatusDto toDto() {
        return new RacingStatusDto(status, carName.getName());
    }

    public int getStatus() {
        return status;
    }

    public String getCarName() {
        return carName.getName();
    }
}
