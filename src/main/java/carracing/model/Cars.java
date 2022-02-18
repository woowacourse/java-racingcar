package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

import java.util.List;
import java.util.stream.Collectors;

import carracing.utils.NumberGenerator;
import carracing.utils.RandomNumberGenerator;

public class Cars {
	private static final int FIRST_CAR_INDEX = 0;
	private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateDuplication(cars);

		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getWinners() {
		Car winner = getWinner();
		return getTiedWith(winner);
	}

	private Car getWinner() {
		Car winningCar = cars.get(FIRST_CAR_INDEX);
		for (Car car : cars) {
			winningCar = getWinningCar(winningCar, car);
		}
		return winningCar;
	}

	private List<Car> getTiedWith(Car winner) {
		return cars.stream()
			.filter(car -> car.isTiedWith(winner))
			.collect(Collectors.toList());
	}

	public void moveCars() {
		cars.forEach(car ->
			car.move(numberGenerator));
	}

	private Car getWinningCar(Car winningCar, Car car) {
		if (car.isAheadOf(winningCar)) {
			winningCar = car;
		}
		return winningCar;
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
