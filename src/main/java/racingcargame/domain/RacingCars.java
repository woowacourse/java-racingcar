package racingcargame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcargame.domain.car.Car;

public class RacingCars {
	private static final String DELIMITER = ",";

	private List<Car> cars;

	public RacingCars(String names) {
		this.cars = createCars(names);
	}

	private List<Car> createCars(String names) {
		cars = new ArrayList<>();
		return Arrays.stream(names.split(DELIMITER))
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public RacingStatus processOneRace(MoveDecider moveDecider) {
		cars.forEach(car -> car.decideMoveOrStop(moveDecider));
		return new RacingStatus(cars);
	}
}
