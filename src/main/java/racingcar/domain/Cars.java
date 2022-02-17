package racingcar.domain;

import static racingcar.Util.Utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.validator.RacingGameValidator;

public class Cars {
	public static final int MOVE_CONDITION = 4;

	private final List<Car> cars = new ArrayList<>();

	public Cars(String[] carNames) {
		RacingGameValidator.validateCarNames(carNames);
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public void startEachRace() {
		cars.stream()
			.filter(car -> isMoveCondition())
			.forEach(Car::moveForward);
	}

	private boolean isMoveCondition() {
		return makeRandom() >= MOVE_CONDITION;
	}

	public List<Car> getWinners() {
		int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	public int getSize() {
		return cars.size();
	}
}
