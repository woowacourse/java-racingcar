package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Cars.java
 * cars 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class Cars implements Iterable<Car> {
	private static final int MINIMUM_NUMBER_OF_CARS = 2;
	private static final String CARS_NULL_EXCEPTION_MESSAGE = "max position car is null";
	private static final String DUPLICATED_CARS_NAME_EXCEPTION_MESSAGE = "name can not be duplicated";
	private static final String NOT_ENOUGH_CAR_EXCEPTION_MESSAGE = "car must be at least one";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validate(cars);
		this.cars = Collections.unmodifiableList(cars);
	}

	private static void validate(List<Car> cars) {
		validateNumberOfName(cars);
		validateDuplicatedName(cars);
	}

	private static void validateNumberOfName(List<Car> cars) {
		if (cars.size() < MINIMUM_NUMBER_OF_CARS) {
			throw new IllegalArgumentException(NOT_ENOUGH_CAR_EXCEPTION_MESSAGE);
		}
	}

	private static void validateDuplicatedName(List<Car> cars) {
		Set<Car> carsWithDistinctName = new HashSet<>(cars);
		if (carsWithDistinctName.size() != cars.size()) {
			throw new IllegalArgumentException(DUPLICATED_CARS_NAME_EXCEPTION_MESSAGE);
		}
	}

	public void moveAll(PowerGenerator powerGenerator) {
		for (Car car : cars) {
			Power power = powerGenerator.generatePower();
			car.move(power);
		}
	}

	public List<Car> findWinners() {
		Car maxPositionCar = findMaxPositionCar();
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.collect(Collectors.toList());
	}

	private Car findMaxPositionCar() {
		return cars.stream()
			.reduce(Car::getFartherCar)
			.orElseThrow(() -> new NullPointerException(CARS_NULL_EXCEPTION_MESSAGE));
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}
