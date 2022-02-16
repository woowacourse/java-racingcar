package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import carracing.utils.NumberGenerator;
import carracing.utils.RandomNumberGenerator;

public class Cars {
	private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateDuplication(cars);

		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getWinners() {
		int maxPosition = cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(NoSuchElementException::new);

		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void moveCars() {
		cars.forEach(car ->
			car.move(numberGenerator));
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
}
