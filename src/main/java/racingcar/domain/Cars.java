package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.strategy.MovingStrategy;

public class Cars {

	private final List<Car> cars = new ArrayList<>();
	private static final String CAR_NAME_DELIMINATOR = ",";

	public Cars(String carNames) {
		String[] parseCarNames = parseCarNames(carNames);

		for (String carName : parseCarNames) {
			Car car = Car.createRandomMovingCar(carName);
			cars.add(car);
		}
	}

	public Cars(String carNames, MovingStrategy movingStrategy) {
		String[] parseCarNames = parseCarNames(carNames);

		for (String carName : parseCarNames) {
			Car car = new Car(carName, movingStrategy);
			cars.add(car);
		}
	}

	public List<Car> get() {
		return cars;
	}

	private String[] parseCarNames(String input) {
		input = input.replaceAll(" ", "");
		return input.split(CAR_NAME_DELIMINATOR);
	}
}
