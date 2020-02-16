package racingcar.Domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/16
 */
public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> inputCars) {
		Objects.requireNonNull(inputCars);
		validateCars(inputCars);
		this.cars = Collections.unmodifiableList(inputCars);
	}

	private void validateCars(List<Car> inputCars) {
		Set<Car> uniqueCars = new HashSet<>(inputCars);
		if (inputCars.size() != uniqueCars.size()) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	public int findTopCarPosition() {
		return cars.stream()
				.map(Car::getPosition)
				.map(Position::getPosition)
				.max(Integer::compare)
				.orElseThrow(IllegalArgumentException::new);
	}

	public List<Name> findWinners(int topCarPosition) {
		return cars.stream()
				.filter(car -> {
					return car.isSamePosition(topCarPosition);
				})
				.map(Car::getCarName)
				.collect(Collectors.toList());
	}
	public List<Car> getCars() {
		return this.cars;
	}
}
