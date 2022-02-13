package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

import racingcar.view.OutPutView;

public class Racing {

	public List<String> race(List<Car> cars, Count count) {
		OutPutView.printStatusMessage();

		while (count.isPositive()) {
			count.subtract();
			moveCars(cars);
			OutPutView.printStatus(cars);
		}

		return getWinners(cars, getMaxPosition(cars));
	}

	private void moveCars(List<Car> cars) {
		cars.forEach(Car::move);
	}

	private int getMaxPosition(List<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	private List<String> getWinners(List<Car> cars, int maxPosition) {
		return cars.stream()
			.filter(car -> maxPosition == car.getPosition())
			.map(Car::getName)
			.collect(toList());
	}
}
