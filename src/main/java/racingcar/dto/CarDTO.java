package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
	private final String carName;
	private final int carPosition;

	public static CarDto from(Car car) {
		return new CarDto(car);
	}

	private CarDto(Car car) {
		this.carName = car.getName();
		this.carPosition = car.getPosition();
	}

	public String getCarName() {
		return carName;
	}

	public int getCarPosition() {
		return carPosition;
	}
}
