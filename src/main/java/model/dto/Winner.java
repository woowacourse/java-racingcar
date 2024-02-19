package model.dto;

import model.Car;

public record Winner(String name) {
    public Winner(Car car) {
        this(car.getName());
    }
}
