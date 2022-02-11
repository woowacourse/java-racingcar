package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.controller.NumberPicker;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.EmptyCarNameException;
import racingcar.exception.OutOfCarNameLengthException;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	public Cars(List<String> names) {
		validateCarNames(names);
		names.forEach(name -> cars.add(new Car(name)));
	}

	private void validateCarNames(List<String> names) {
		validateNameIsTooLong(names);
		validateNameIsEmpty(names);
		validateNameIsDuplicate(names);
	}

	private void validateNameIsTooLong(List<String> names) {
		if (names.stream().anyMatch(CarNameLength::isTooLong)) {
			throw new OutOfCarNameLengthException();
		}
	}

	private void validateNameIsDuplicate(List<String> names) {
		if (names.stream().anyMatch(name -> Collections.frequency(names, name) > 1)) {
			throw new DuplicateCarNameException();
		}
	}

	private void validateNameIsEmpty(List<String> names) {
		if (names.stream().anyMatch(String::isEmpty)) {
			throw new EmptyCarNameException();
		}
	}

	public void play(NumberPicker numberPicker) {
		for (Car car : cars) {
			car.goForwardOrStop(numberPicker.pickNumber());
		}
	}

	public List<String> getStatuses() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}

	public List<String> getWinnerNames() {
		int farthestLocation = getFarthestLocation();
		return cars.stream()
			.filter(car -> car.getLocation() == farthestLocation)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getFarthestLocation() {
		return cars.stream()
			.map(Car::getLocation)
			.max((Comparator.comparingInt(o -> o)))
			.orElseThrow(IllegalArgumentException::new);
	}
}
