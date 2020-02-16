package racingcar.Domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 클래스 이름 : Cars.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> inputCars) {
		Objects.requireNonNull(inputCars);
		validateCars(inputCars);
		this.cars = Collections.unmodifiableList(inputCars);
	}

	private void validateCars(final List<Car> inputCars) {
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

	public List<Name> findWinners(final int topCarPosition) {
		return cars.stream()
				.filter(car -> car.isSamePosition(topCarPosition))
				.map(Car::getCarName)
				.collect(Collectors.toList());
	}

	public List<Car> getCars() {
		return this.cars;
	}
}
