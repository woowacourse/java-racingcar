package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.controller.NumberPicker;
import racingcar.exception.DuplicateCarNameException;

public class Cars {

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		cars = Collections.unmodifiableList(cars);
		validateDuplicate(cars);
		this.cars = cars;
	}

	public static Cars from(String[] names) {
		return new Cars(Arrays.stream(names)
			.map(Name::new)
			.map(Car::new)
			.collect(Collectors.toList()));
	}

	private void validateDuplicate(List<Car> cars) {
		boolean duplicated = cars.stream()
			.map(Car::getName)
			.distinct()
			.count() != cars.size();

		if (duplicated) {
			throw new DuplicateCarNameException();
		}
	}

	public void play(NumberPicker numberPicker) {
		for (Car car : cars) {
			car.goForwardOrStop(numberPicker.pickNumber());
		}
	}

	public List<String> getWinnerNames() {
		int farthestLocation = getFarthestLocation();
		return cars.stream()
			.filter(car -> car.isWinner(farthestLocation))
			.map(Car::getName)
			.map(Name::getName)
			.collect(Collectors.toList());
	}

	private int getFarthestLocation() {
		List<Integer> carLocations = cars.stream()
			.map(Car::getLocation)
			.collect(Collectors.toList());

		return Collections.max(carLocations);
	}

	public List<Car> getCars() {
		return new ArrayList<>(cars);
	}
}
