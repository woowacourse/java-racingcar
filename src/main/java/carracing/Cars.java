package carracing;

import java.util.List;

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
}
