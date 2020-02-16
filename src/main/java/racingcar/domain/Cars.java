package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String DELIMITER = ",";
	private static final int LIMIT = -1;
	private static final int INIT_POSITION = 0;
	private static final int MINIMUM_TEAM = 2;

	private List<Car> cars;

	public Cars(String inputNames) {
		String[] names = inputNames.split(DELIMITER, LIMIT);

		cars = Arrays.stream(names)
			.map(name -> new Car(name.trim(), INIT_POSITION))
			.collect(Collectors.toList());

		validateTeamCount();
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public List<String> getWinners() {
		final Car maxPositionCar = getMaxPositionCar();

		return getSameCars(maxPositionCar);
	}

	private Car getMaxPositionCar() {
		return cars.stream()
			.max(Car::compareTo)
			.orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
	}

	private List<String> getSameCars(Car maxPositionCar) {
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void validateTeamCount() {
		if (cars.size() < MINIMUM_TEAM) {
			throw new IllegalArgumentException("참가자는 " + MINIMUM_TEAM + "명 이상이어야합니다.");
		}
	}
}
