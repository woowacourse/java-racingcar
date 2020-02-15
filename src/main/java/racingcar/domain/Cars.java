package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String DELIMITER = ",";
	private static final int MINIMUM_TEAM = 2;
	private static final int LIMIT = -1;

	private List<Car> cars;

	public Cars(String inputNames) {
		String[] names = inputNames.split(DELIMITER, LIMIT);

		cars = Arrays.stream(names)
			.map(name -> new Car(name.trim()))
			.collect(Collectors.toList());

		validateTeamCount();
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<String> getWinners() {
		final Car maxPositionCar = cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException("차가 없습니다."));

		return cars.stream()
			.filter(car -> car.isMaxPosition(maxPositionCar))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void validateTeamCount() {
		if (cars.size() < MINIMUM_TEAM) {
			throw new IllegalArgumentException("참가자는 " + MINIMUM_TEAM + "명 이상이어야합니다.");
		}
	}
}
