package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";
	private static final String DELIMITER = ",";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateDuplicateNames(cars);
		this.cars = cars;
	}

	private void validateDuplicateNames(List<Car> cars) {
		boolean isDuplicated = cars.stream()
			.map(Car::getName)
			.distinct()
			.count() != cars.size();
		if (isDuplicated) {
			throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
		}
	}

	public RacingResult moveByIndex(int index, RandomNo randomNo) {
		Car car = cars.get(index);
		car.move(randomNo);
		return new RacingResult(car.getName(), car.getPosition());
	}

	public int getSize() {
		return cars.size();
	}

	public int getMaxPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.max(Integer::compareTo)
			.get();
	}

	public List<Car> findByPosition(int position) {
		return cars.stream()
			.filter(car -> car.isSamePosition(position))
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::getName)
			.map(Name::getName)
			.collect(Collectors.joining(DELIMITER));
	}
}
