package model.dto;

import model.Car;

public record CarState(String name, int forwardCount) {
    public CarState(Car car) {
        this(car.getName(), car.getForwardCount());
    }
}
