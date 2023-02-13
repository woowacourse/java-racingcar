package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {
	private static final Map<String, Car> cars = new HashMap<>();

	public static void add(Car car) {
		validateCarName(car);
		cars.put(car.getName(), car);
	}

	private static void validateCarName(Car car) {
		if (cars.containsKey(car.getName())) {
			throw new IllegalArgumentException("[ERROR]: 중복된 차 이름이 있습니다.");
		}
	}

	public static List<Car> getCars() {
		return List.copyOf(cars.values());
	}

	public static void clear() {
		cars.clear();
	}
}
