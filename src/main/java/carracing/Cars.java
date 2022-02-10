package carracing;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		boolean isDuplicated = cars.stream()
			.map(Car::getName)
			.distinct()
			.count() != cars.size();
		if (isDuplicated) {
			throw new IllegalArgumentException("자동차 이름은 중복이 되면 안됩니다.");
		}
		this.cars = cars;
	}

	public List<String> getWinners() {
		Integer max = cars.stream()
			.mapToInt(car -> car.getPosition())
			.max()
			.orElseThrow(NoSuchElementException::new);

		return cars.stream()
			.filter(car -> car.getPosition() == max)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void moveCars() {
		cars.stream()
			.forEach(car -> {
				car.move((int)Math.random() * 10);
			});
	}
}
