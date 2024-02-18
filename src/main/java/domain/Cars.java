package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveAll() {
		cars.forEach(Car::move);
	}

	public Map<String, Integer> getCurrentLocations() {
		Map<String, Integer> locations = new LinkedHashMap<>();

		cars.forEach(car -> locations.put(car.getCarName(), car.getCarLocation()));
		return locations;
	}

	public List<String> getLargestLocationCarNames() {
		return cars.stream()
			.filter(car -> car.getCarLocation() == getLargestLocation())
			.map(Car::getCarName)
			.toList();
	}

	private int getLargestLocation() {
		return cars.stream()
			.mapToInt(Car::getCarLocation)
			.max()
			.getAsInt();
	}
}
