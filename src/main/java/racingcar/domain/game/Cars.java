package racingcar.domain.game;

import static racingcar.messsages.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovement;

public class Cars {
	private static final int CARS_MIN_SIZE = 2;

	private final List<Car> cars = new ArrayList<>();

	public void addCars(final List<Car> cars) {
		validateCarsSizeOneOrZero(cars);
		validateDuplicatedCarName(cars);
		this.cars.clear();
		this.cars.addAll(cars);
	}

	// enum 활용
	public void moveCarsV1(final CarMovement carMovement) {
		cars.forEach(car -> car.moveV1(carMovement.moveV1()));
	}

	// 전략 패턴
	public void moveCarsV2(final CarMovement carMovement) {
		cars.forEach(car -> car.moveV2(carMovement.moveV2()));
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	private void validateCarsSizeOneOrZero(final List<Car> cars) {
		if (cars.size() < CARS_MIN_SIZE) {
			throw new IllegalArgumentException(CARS_SIZE_EXCEPTION.getMessage());
		}
	}

	private void validateDuplicatedCarName(final List<Car> cars) {
		final Set<String> removedDuplicatedCarNames = cars.stream()
			.map(Car::getNameValue)
			.collect(Collectors.toUnmodifiableSet());
		if (removedDuplicatedCarNames.size() != cars.size()) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
		}
	}
}
