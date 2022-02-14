package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import racingcar.validator.RacingGameValidator;

public class Cars {
	public static final int MOVE_CONDITION = 4;
	public static final int RANDOM_NUMBER_BOUND = 10;

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

	private int makeRandom() {
		Random random = new Random();
		return random.nextInt(RANDOM_NUMBER_BOUND);
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();
		return this.cars.stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public int getSize() {
		return cars.size();
	}

	public List<String> getAllPosition() {
		return this.cars.stream()
			.map(Car::toString)
			.collect(Collectors.toList());
	}
}
