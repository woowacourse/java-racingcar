package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import carracing.utils.RandomNumber;
import carracing.view.OutputView;

public class Cars {
	public static final int RANDOM_NUMBER_RANGE = 10;

	private List<Car> cars;

	public Cars(List<Car> cars) {
		boolean isDuplicated = cars.stream()
			.map(Car::getName)
			.distinct()
			.count() != cars.size();
		if (isDuplicated) {
			throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
		}
		this.cars = cars;
	}

	public List<String> getWinners() {
		Integer max = cars.stream()
			.mapToInt(car -> car.getPosition())
			.max()
			.orElseThrow(NoSuchElementException::new);

		return cars.stream()
			.filter(car -> car.getPosition() == max)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void moveCars() {
		cars.stream()
			.forEach(car -> {
				car.move(RandomNumber.generate(RANDOM_NUMBER_RANGE));
			});
	}

	public void printResult() {
		cars.stream()
			.forEach(car -> {
				OutputView.printCarPosition(car.toString());
			});
		OutputView.printNewLine();
	}
}
