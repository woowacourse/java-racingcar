package model.dto;

import model.Car;

public record CarState(String name, int forwardCount) {
    public static CarState create(Car car) {
        return new CarState(car.getName(), car.getForwardCount());
    }
}
