package racingcar;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CarFactory {
	private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

	public static Set<Car> of(String names) {
		String[] arrNames = names.split(",");
		Set<Car> cars = Arrays.stream(arrNames)
			.map(name -> new Car(name.trim()))
			.collect(Collectors.toSet());
		validateDuplicatedCarName(arrNames, cars);
		return cars;
	}

	private static void validateDuplicatedCarName(String[] arrNames, Set<Car> cars) {
		if (arrNames.length != cars.size()) {
			throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
		}
	}
}
