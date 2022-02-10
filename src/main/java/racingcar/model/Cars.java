package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.message.ErrorMessages;
import racingcar.util.RandomGenerator;

public class Cars {
	private static final String NEW_LINE = System.lineSeparator();
	private static final String DELIMITER = ",";
	private static final int MIN = 0;
	private static final int MAX = 9;

	private final List<Car> cars = new ArrayList<>();

	public Cars(String carNames) {
		String[] carNameArray = carNames.replaceAll(" ", "").split(DELIMITER);
		if (validateDuplicatedName(carNameArray)) {
			throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
		}
		for (String carName : carNameArray) {
			cars.add(new Car(carName));
		}
	}

	public void moveAll() {
		for (Car car : cars) {
			car.goOrStop(RandomGenerator.generateNumber(MIN, MAX + 1));
		}
	}

	public Winners getWinners() {
		return new Winners(cars);
	}

	private boolean validateDuplicatedName(String[] carNames) {
		long distinctSize = Arrays.stream(carNames)
			.distinct().count();

		return distinctSize != carNames.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Car car : cars) {
			sb.append(car.toString())
				.append(NEW_LINE);
		}
		return sb.toString();
	}
}
