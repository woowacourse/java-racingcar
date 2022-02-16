package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Random;

public class Cars {
	private static final String ERROR_DUPLICATED_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
	private static final String ERROR_CAR_COUNT = "[ERROR] 자동차를 1대 이상 입력해야 합니다.";
	private static final int ZERO = 0;
	private static final int BOUND_RANDOM = 10;
	private final ArrayList<Car> cars;

	public Cars(ArrayList<Car> cars) {
		checkCarCount(cars);
		checkDuplicatedName(cars);

		this.cars = cars;
	}

	private void checkDuplicatedName(ArrayList<Car> cars) {
		ArrayList<String> nameList = new ArrayList<>();
		HashSet<String> nameSet = new HashSet<>();
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
		if (cars.size() == ZERO) {
			throw new IllegalArgumentException(ERROR_CAR_COUNT);
		}
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public int getMaxPosition() {
		int max = ZERO;

		for (Car car : cars) {
			max = Math.max(max, car.getPosition());
		}

		return max;
	}

	public void moveCars() {
		ArrayList<Integer> randomNumberArray = generateRandNumArray(cars.size());

		for (int index = ZERO; index < cars.size(); index++) {
			cars.get(index).movePosition(randomNumberArray.get(index));
		}
	}

	private ArrayList<Integer> generateRandNumArray(int size) {
		ArrayList<Integer> randomNumberArray = new ArrayList<>();

		for (int index = ZERO; index < size; index++) {
			randomNumberArray.add(generateRandNum());
		}

		return randomNumberArray;
	}

	private int generateRandNum() {
		Random random = new Random();

		return random.nextInt(BOUND_RANDOM);
	}

	public LinkedHashMap<String, Integer> getCarsInfo() {
		LinkedHashMap<String, Integer> carsInfo = new LinkedHashMap<>();

		for (Car car : this.cars) {
			carsInfo.put(car.getName(), car.getPosition());
		}

		return carsInfo;
	}
}
