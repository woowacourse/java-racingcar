package com.woowacourse.javaracingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayingCars {
    // update 등 이름으로 객체를 빠르게 검색하기 위한 맵
    private final Map<String, Car> cars;
    // 인자로 전달되는 Car 객체의 순서를 보존하기 위한 리스트
    private final List<Car> carList;

    public PlayingCars(final List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        this.carList = cars;
        this.cars = new HashMap<>();
        cars.forEach(c -> this.cars.put(c.getName(), c));
    }

    public void update(final CarDto car) {
        Car foundCar = cars.get(car.getName());
        if (foundCar == null) {
            throw new IllegalArgumentException("Car was not found with name: " + car.getName());
        }

        foundCar.move(car.getPosition() - foundCar.getPosition());
    }

    public List<CarDto> retrieveAllCars() {
        return carList.stream()
            .map(c -> new CarDto(c.getName(), c.getPosition()))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayingCars [ ");
        carList.forEach(sb::append);
        sb.append(" ]");
        return sb.toString();
    }
}
