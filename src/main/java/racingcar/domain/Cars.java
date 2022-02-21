package racingcar.domain;

import static racingcar.Util.Utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
	public static final String ERROR_ONLY_NAME = "[ERROR] 이름을 2개 이상 입력해주세요.";
	public static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 있습니다.";
	public static final int DEFAULT_POSITION = 0;
	public static final int MOVE_CONDITION = 4;

	private final List<Car> cars = new ArrayList<>();

	public Cars(String[] carNames) {
		validateCarNames(carNames);
		for (String carName : carNames) {
			cars.add(new Car(carName, DEFAULT_POSITION));
		}
	}

	private void validateCarNames(String[] names) {
		checkDuplicateName(names);
		checkOnlyName(names);
	}

	private static void checkOnlyName(String[] names) {
		if (names.length == 1) {
			throw new IllegalArgumentException(ERROR_ONLY_NAME);
		}
	}

	private static void checkDuplicateName(String[] names) {
		Set<String> hashNames = new HashSet<>(Arrays.asList(names));
		if (hashNames.size() != names.length) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
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

	public Map<String, Integer> getCarsInfo() {
		return cars.stream()
			.collect(Collectors.toMap(car -> car.getName().toString(),
				car -> car.getPosition().toInt(), (a, b) -> b));
	}

	public Winners getWinners() {
		return new Winners(cars);
	}
}
