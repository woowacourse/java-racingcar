package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.MovingNumberPolicy;

public class Cars {

	private static final String EMPTY_CAR_ERROR_MESSAGE = "등록된 자동차가 없습니다.";

	private final List<Car> cars = new ArrayList<>();

	public void add(List<Car> cars) {
		this.cars.addAll(cars);
	}

	public void moveCars(MovingNumberPolicy movingNumberPolicy) {
		cars.forEach(car -> car.move(movingNumberPolicy.generate()));
	}

	public List<Car> findCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<Car> findWinnerCars() {
		Car maxPositionCar = cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalStateException(EMPTY_CAR_ERROR_MESSAGE));

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.collect(Collectors.toList());
	}
}
