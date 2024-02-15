package view.dto;

import model.Car;

public class CarDto {

    private final String carName;
    private final int movement;

    public CarDto(Car car) {
        this.carName = car.getCarName();
        this.movement = car.getMovement();
    }

    public String getCarName() {
        return carName;
    }

    public int getMovement() {
        return movement;
    }
}
