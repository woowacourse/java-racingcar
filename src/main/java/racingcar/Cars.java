package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

	private Set<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = new HashSet<>(cars);
		validateDuplicatedCars(cars);
	}

	public Set<Car> getCars() {
		return cars;
	}

	public int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.getAsInt();
	}

	private void validateDuplicatedCars(List<Car> cars) {
		if (cars.size() != this.cars.size()) {
			throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
		}
	}
}
