package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Random;

public class Cars implements CarMoveCondition {
	private static final String ERROR_DUPLICATED_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
	private static final String ERROR_CAR_COUNT = "[ERROR] 자동차를 1대 이상 입력해야 합니다.";
	private static final int MINIMUM_NUMBER_OF_CAR = 1;
	private static final int BOUND_RANDOM = 10;
	private final ArrayList<Car> cars;

	public Cars(ArrayList<Car> cars) {
		checkCarCount(cars);
		checkDuplicatedName(cars);

		this.cars = cars;
	}

	private void checkDuplicatedName(ArrayList<Car> cars) {
		ArrayList<String> nameList = new ArrayList<>();
		final HashSet<String> nameSet = new HashSet<>();
		for (Car car : cars) {
			nameList.add(car.getName());
			nameSet.add(car.getName());
		}
		throwDuplicatedNameError(nameList, nameSet);
	}

	private void throwDuplicatedNameError(ArrayList<String> nameList, HashSet<String> nameSet) {
		if (nameList.size() != nameSet.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATED_NAME);
		}
	}

	private void checkCarCount(ArrayList<Car> cars) {
		if (cars.size() < MINIMUM_NUMBER_OF_CAR) {
			throw new IllegalArgumentException(ERROR_CAR_COUNT);
		}
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public int getMaxPosition() {
		int max = 0;

		for (Car car : cars) {
			max = Math.max(max, car.getPosition());
		}

		return max;
	}

	public void moveCars() {
		for (Car car : cars) {
			car.movePosition(satisfy(generateRandNum()));
		}
	}

	private int generateRandNum() {
		Random random = new Random();

		return random.nextInt(BOUND_RANDOM);
	}

	public LinkedHashMap<String, Integer> getCarsInfo() {
		final LinkedHashMap<String, Integer> carsInfo = new LinkedHashMap<>();

		for (Car car : this.cars) {
			carsInfo.put(car.getName(), car.getPosition());
		}

		return carsInfo;
	}
}
