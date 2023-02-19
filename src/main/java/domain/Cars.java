package domain;

import java.util.List;
import java.util.StringJoiner;

import domain.strategy.MovingStrategy;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars(MovingStrategy movingStrategy) {
		cars.forEach(car -> car.move(movingStrategy));
	}

	public String winners() {
		int maxPosition = 0;
		for (Car value : cars) {
			if (maxPosition < value.getPosition()) {
				maxPosition = value.getPosition();
			}
		}

		StringJoiner finalWinners = new StringJoiner(", ");
		for (Car value : cars) {
			if (value.getPosition() == maxPosition) {
				finalWinners.add(value.getName());
			}
		}
		return finalWinners.toString();
	}

	public List<Car> getCars() {
		return cars;
	}
}
