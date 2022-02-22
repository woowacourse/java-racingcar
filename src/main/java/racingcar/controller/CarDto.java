package racingcar.controller;

import racingcar.domain.Car;

public class CarDto {

	private final String name;
	private final int location;

	public CarDto(final String name, final int location) {
		this.name = name;
		this.location = location;
	}

	public static CarDto from(Car car) {
		return new CarDto(car.getName().getName(), car.getLocation());
	}

	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}
}
