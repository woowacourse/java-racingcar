package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
	private static final String ERROR_CAR_NAMES_DUPLICATE_MESSAGE = "중복된 자동차 이름이 입력됐습니다.";
	private static final String ERROR_INVALID_LIST_SIZE = "전달된 리스트 크기가 작습니다.";

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public void createCars(String[] carNames) {
		cars.clear();
		checkDuplicationCarNames(carNames);
		Arrays.stream(carNames)
			.map(Car::new)
			.forEach(cars::add);
	}

	public void moveAll(List<Integer> randoms) {
		validateRandomsSize(randoms);
		int i = 0;
		for (Car car : cars) {
			car.move(randoms.get(i));
			i++;
		}
	}

	private void validateRandomsSize(List<Integer> randoms) {
		if (randoms.size() < cars.size()) {
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

	private void checkDuplicationCarNames(String[] carNames) {
		Set<String> duplicationCheck = new HashSet<>(Arrays.asList(carNames));
		if (duplicationCheck.size() != carNames.length) {
			throw new IllegalArgumentException(ERROR_CAR_NAMES_DUPLICATE_MESSAGE);
		}
	}
}
