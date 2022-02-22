package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
	private static final Cars cars = new Cars();

	private Racing() {
	}

	public static void createCars(List<String> carNames) {
		cars.createCars(carNames);
	}

	public static List<List<Car>> runForIteration(int iteration) {
		return IntStream.range(0, iteration)
			.mapToObj(i -> moveCars())
			.collect(Collectors.toList());
	}

	public static List<Car> moveCars() {
		int numberOfCars = cars.getSize();
		return cars.moveAll(Random.createNumbers(numberOfCars));
	}

	public static List<Car> getWinners() {
		return cars.getWinners();
	}
}
