package domain;

import dto.RacingStatusDto;

public class Car {

    private final CarName carName;
    private int status;

    public Car(String carName) {
        this.carName = new CarName(carName);
        status = 0;
    }

    public Car(Car needToCopy) {
        carName = needToCopy.carName;
        status = needToCopy.status;
    }

    public void move() {
        status++;
    }

    public RacingStatusDto toDto() {
        return new RacingStatusDto(status, carName.getName());
    }

}
