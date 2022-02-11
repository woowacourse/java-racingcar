package racingcar.domain;

import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
	private static final String MAX_FIND_ERROR = "max 값을 찾을 수 없습니다.";
	private static final int DRIVE_FLAG = 3;
	private static final int RANDOM_MULTIPLE = 100;
	private static final int RANDOM_DIVISION = 10;
	private List<Car> cars;

	public Cars(String[] names) {
		cars = new ArrayList<>();
		for (String name : names) {
			cars.add(createCar(name));
		}
	}

	public void play() {
		for (Car car : cars) {
			car.drive(hasNext());
		}
		Output.roundResult(cars);
	}

	private boolean hasNext() {
		return generate() > DRIVE_FLAG;
	}

	private int generate() {
		return (int)(Math.random() * RANDOM_MULTIPLE) % RANDOM_DIVISION;
	}

	private Car createCar(String name) {
		return new Car(name.trim());
	}

	public List<String> findWinners() {
		Car maxPositionCar = findMaxPositionCar();
		return findSamePositionCar(maxPositionCar);
	}

	private Car findMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new NoSuchElementException(MAX_FIND_ERROR));
	}

	private List<String> findSamePositionCar(Car target) {
		return cars.stream()
			.filter(car -> car.isSamePosition(target))
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
