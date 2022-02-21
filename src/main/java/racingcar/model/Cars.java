package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
	private static final String ERROR_CAR_NAMES_DUPLICATE_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";
	private static final String ERROR_INVALID_LIST_SIZE = "전달된 리스트 크기가 작습니다.";
	private static final String ERROR_CAR_NAMES_EMPTY = "빈 자동차 이름이 입력됐습니다.";

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void createCars(List<String> carNames) {
		cars.clear();
		validateCarNames(carNames);
		carNames.stream()
			.map(Car::new)
			.forEach(cars::add);
	}

	public List<Car> moveAll(List<Integer> MovingConditions) {
		validateMovingConditionsSize(MovingConditions);
		int i = 0;
		for (Car car : cars) {
			car.move(MovingConditions.get(i));
			i++;
		}
		return cars;
	}

	private void validateMovingConditionsSize(List<Integer> MovingConditions) {
		if (MovingConditions.size() < cars.size()) {
			throw new IllegalStateException(ERROR_INVALID_LIST_SIZE);
		}
	}

	public int getSize() {
		return cars.size();
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Car> getWinners() {
		return cars.stream()
			.filter(car -> car.isSamePosition(maxPosition()))
			.collect(Collectors.toList());
	}

	private int maxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = car.getBiggerPosition(maxPosition);
		}
		return maxPosition;
	}

	private void validateCarNames(List<String> carNames) {
		validateEmptyCarNames(carNames);
		validateDuplicationCarNames(carNames);
	}

	private void validateDuplicationCarNames(List<String> carNames) {
		Set<String> distinct = new HashSet<>(carNames);
		if (distinct.size() != carNames.size()) {
			throw new IllegalArgumentException(ERROR_CAR_NAMES_DUPLICATE_MESSAGE);
		}
	}

	private void validateEmptyCarNames(List<String> carNames) {
		if (carNames.isEmpty()) {
			throw new IllegalArgumentException(ERROR_CAR_NAMES_EMPTY);
		}
	}
}
