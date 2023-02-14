package racingcar.dto;

import java.util.List;

import racingcar.domain.car.Car;

public class RoundResultResponse {
	private final List<Car> cars;

	public static RoundResultResponse from(final List<Car> cars) {
		return new RoundResultResponse(cars);
	}

	private RoundResultResponse(final List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
}
