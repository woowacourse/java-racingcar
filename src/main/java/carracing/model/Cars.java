package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import carracing.utils.RandomNumber;

public class Cars {
	private static final int RANDOM_NUMBER_RANGE = 10;

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateDuplication(cars);

		this.cars = cars;
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();

		return cars.stream()
			.filter(car -> car.isEqualTo(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void moveCars() {
		cars.forEach(car ->
			car.move(RandomNumber.generate(RANDOM_NUMBER_RANGE)));
	}

	private void validateDuplication(List<Car> cars) {
		boolean isDuplicated = cars.stream()
			.map(Car::getName)
			.distinct()
			.count() != cars.size();

		if (isDuplicated) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
		}
	}

	private int getMaxPosition() {
		return cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElseThrow(NoSuchElementException::new);
	}

	public List<Car> getCars() {
		return cars;
	}
}
