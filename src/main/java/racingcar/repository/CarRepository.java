package racingcar.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.domain.Car;

public class CarRepository {
	private static final List<Car> cars = new ArrayList<>();
	private static final Set<String> carNames = new HashSet<>();

	public static void add(Car car) {
		validateCarName(car);
		cars.add(car);
		carNames.add(car.getName());
	}

	private static void validateCarName(Car car) {
		if (carNames.contains(car.getName())) {
			throw new IllegalArgumentException("[ERROR]: 중복된 차 이름이 있습니다.");
		}
	}

	public static List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public static void clear() {
		cars.clear();
		carNames.clear();
	}
}
