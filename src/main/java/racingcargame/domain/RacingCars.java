package racingcargame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

	private static final String DELIMITER = ",";

	private List<Car> cars;

	public RacingCars(String names) {
		this.cars = createCars(names);
	}

	private List<Car> createCars(String names) {
		cars = new ArrayList<>();
		String[] carNames = names.split(DELIMITER);

		return Arrays.stream(carNames)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public CarStatus processOneRace(MoveDecider moveDecider) {
		cars.forEach(car -> car.decideGoOrStop(moveDecider));
		return new CarStatus(cars);
	}

	public List<String> getWinners() {
		Collections.sort(cars);
		int maxPosition = cars.get(0).getCarPosition();

		return cars.stream()
			.filter(car -> car.isMaxPosition(maxPosition))
			.map(Car::getCarName)
			.collect(Collectors.toList());
	}
}
