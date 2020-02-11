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

	public List<Car> findWinner() {
		return cars.stream()
			.filter(car -> car.isWinner(findWinnersPosition()))
			.collect(Collectors.toList());
	}

	private int findWinnersPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.reduce(Integer::max)
			.orElse(0);
	}

	// 테스트코드에서만 사용하는 getter 메소드
	public List<Car> getCars() {
		return this.cars;
	}
}
