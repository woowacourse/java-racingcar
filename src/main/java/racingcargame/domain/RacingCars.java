package racingcargame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcargame.domain.car.Car;

public class RacingCars {
	public static final String DELIMITER = ",";

	private List<Car> cars;

	public RacingCars(String names) {
		validateOnlyDelimiter(names);
		this.cars = createCars(names);
	}

	private void validateOnlyDelimiter(String names) {
		if (names.equals(DELIMITER)) {
			throw new IllegalArgumentException("구분자를 기준으로 이름을 입력해주세요.");
		}
	}

	private List<Car> createCars(String names) {
		cars = new ArrayList<>();
		return Arrays.stream(names.split(DELIMITER))
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public RacingLog processOneRace(MoveStrategy moveStrategy) {
		cars.forEach(car -> car.decideMoveOrStop(moveStrategy.getRandomNo()));
		return new RacingLog(cars);
	}
}
