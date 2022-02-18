package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import racingcar.validator.RacingCarValidator;

public class Racing {
	private final List<Car> cars;
	private final Count count;

	public Racing(String[] carNames, String tryNo) {
		List<Car> inputCars = getCars(carNames);
		RacingCarValidator.validateCars(inputCars);

		this.cars = inputCars;
		this.count = new Count(tryNo);
	}

	private List<Car> getCars(String[] carNames) {
		return Arrays.stream(carNames)
			.map(Car::new)
			.collect(toList());
	}

	public boolean isEnd() {
		return !count.isPositive();
	}

	public List<Car> race() {
		count.subtract();
		moveCars(cars);

		return cars;
	}

	private void moveCars(List<Car> cars) {
		cars.forEach(car -> car.move(new RandomMovingPolicy()));
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();

		return cars.stream()
			.filter(car -> maxPosition == car.getPosition())
			.map(Car::getName)
			.collect(toList());
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}
}
