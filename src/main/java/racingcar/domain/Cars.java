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
			this.cars.add(new Car(carName));
		}
	}

	public void startEachRace() {
		cars.stream()
			.filter(car -> isMoveCondition())
			.forEach(Car::moveForward);
	}

	private boolean isMoveCondition() {
		return makeRandom() >= MOVE_CONDITION;
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	public List<Car> getWinners() {
		int maxPosition = getMaxPosition();
		return this.cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.collect(Collectors.toList());
	}

	public int getSize() {
		return cars.size();
	}

	public List<String> getAllPositionToString() {
		return this.cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}
}
