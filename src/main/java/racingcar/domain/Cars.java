package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String DELIMITER = ",";
	private static final int MINIMUM_TEAM = 2;
	private static final int MAX_NAME_LENGTH = 5;
	private static final int LIMIT = -1;

	private List<Car> cars;

	public Cars(String inputNames) {
		String[] names = inputNames.split(DELIMITER, LIMIT);

		cars = Arrays.stream(names)
			.map(name -> new Car(name.trim()))
			.collect(Collectors.toList());

		validateCarNames();
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getWinners() {
		final int maximum = cars.stream()
			.map(Car::getPosition)
			.max(Integer::compareTo)
			.get();

		return cars.stream()
			.filter(car -> car.getPosition() == maximum)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void validateCarNames() {
		if (cars.size() < MINIMUM_TEAM) {
			throw new IllegalArgumentException("참가자는 " + MINIMUM_TEAM + "명 이상이어야합니다.");
		}

		if (cars.stream()
			.anyMatch(Car::hasOverFiveCharacterName)) {
			throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
		}
	}
}
