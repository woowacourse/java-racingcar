package racingCar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import racingCar.exception.DuplicatedNameException;
import racingCar.exception.OnlyOneNameException;
import racingCar.utlis.Util;

public class RacingCars {
	private final List<Car> cars = new ArrayList<>();

	public RacingCars(List<String> cars) {
		validate(cars);
		for (String car : cars) {
			this.cars.add(new Car(car));
		}
	}

	private static void validate(List<String> cars) {
		if (cars.size() <= 1) {
			throw new OnlyOneNameException();
		}
		if (new HashSet<>(cars).size() != cars.size()) {
			throw new DuplicatedNameException();
		}

	}

	public void addCar(Car car) {
		this.cars.add(car);
	}

	public void GoRound() {
		for (Car car : cars) {
			car.go();
		}
	}

	public String getRoundResult() {
		StringBuilder result = new StringBuilder();
		for (Car car : cars) {
			result.append(car.getStateString());
		}
		return result.toString();
	}

	public int getMaxPosition() {
		ArrayList<Integer> positions = new ArrayList<>();
		for (Car car : cars) {
			positions.add(car.position.get());
		}
		return Util.getMax(positions);
	}

	public List<String> getSamePositionCars(int position) {
		return cars
			.stream()
			.filter(car -> car.position.isSame(position))
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
