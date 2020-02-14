package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsFactory {
	private static final int MINIMUM_NUMBER_OF_CARS = 2;
	private static final String SPACE = " ";
	private static final String EMPTY = "";
	private static final String COMMA = ",";
	private static final int LIMIT = -1;

	public static Cars createCars(String carsNameInput) {
		List<String> carsName = removeSpaceAndSplit(carsNameInput);

		validateDuplicateCarName(carsName);
		validateNumberOfCars(carsName);

		List<Car> cars = new ArrayList<>();
		carsName.forEach(carName -> cars.add(new Car(carName)));
		return new Cars(cars);
	}

	private static void validateDuplicateCarName(List<String> carsName) {
		if (carsName.stream()
				.distinct()
				.count() != carsName.size()) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	private static void validateNumberOfCars(List<String> carsName) {
		if (carsName.size() < MINIMUM_NUMBER_OF_CARS) {
			throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
		}
	}

	private static List<String> removeSpaceAndSplit(String carsNameInput) {
		return Arrays.asList(carsNameInput.replace(SPACE, EMPTY)
				.split(COMMA, LIMIT));
	}
}
