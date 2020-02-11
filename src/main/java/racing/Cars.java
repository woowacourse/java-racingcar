package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars;

	public Cars(List<String> input) {
		cars = input.stream().map(Car::new).collect(Collectors.toList());
	}

	public int size() {
		return cars.size();
	}

	public List<String> getAllNames() {
		return cars.stream().map(Car::getName).collect(Collectors.toList());
	}
}
