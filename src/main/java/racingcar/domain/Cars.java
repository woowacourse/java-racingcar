package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.controller.NumberPicker;

public class Cars {

	private final List<Car> cars = new ArrayList<>();

	public Cars(Names names) {
		names.getNames().forEach(name -> cars.add(new Car(name)));
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

	public List<Name> getWinnerNames() {
		int farthestLocation = getFarthestLocation();
		return cars.stream()
			.filter(car -> car.isWinner(farthestLocation))
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
