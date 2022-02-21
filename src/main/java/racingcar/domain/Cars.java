package racingcar.domain;

import racingcar.service.MovePolicy;
import racingcar.util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> cars;

	public Cars(String[] names) {
		List<Car> cars = toCars(names);
		carsValid(cars);
		this.cars = cars;
	}

	public Cars(List<Car> cars) {
		carsValid(cars);
		this.cars = cars;
	}

	private void carsValid(List<Car> cars) {
		if (!isCars(cars)) {
			throw new IllegalArgumentException(Constant.CARS_ERROR_MESSAGE);
		}
		if (isDuplicated(cars)) {
			throw new IllegalArgumentException(Constant.CAR_DUPLICATED_ERROR_MESSAGE);
		}
	}

	private boolean isCars(List<Car> cars) {
		return cars.size() >= Constant.CAR_LIMIT;
	}

	private boolean isDuplicated(List<Car> cars) {
		return cars.stream()
			.distinct()
			.count() != cars.size();
	}

	public void play(MovePolicy movePolicy) {
		for (Car car : cars) {
			car.drive(movePolicy);
		}
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	private static List<Car> toCars(String[] names) {
		List<Car> cars = new ArrayList<>();

		for (String name : names) {
			cars.add(createCar(name));
		}
		return cars;
	}

	private static Car createCar(String name) {
		return new Car(name.trim());
	}

	public List<String> findWinners() {
		Car maxPositionCar = findMaxPositionCar();
		return findSamePositionCar(maxPositionCar);
	}

	private Car findMaxPositionCar() {
		return cars
			.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new NoSuchElementException(Constant.MAX_FIND_ERROR));
	}

	private List<String> findSamePositionCar(Car target) {
		return cars.stream()
			.filter(car -> car.isSamePosition(target))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Cars{" +
			"cars=" + cars +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
