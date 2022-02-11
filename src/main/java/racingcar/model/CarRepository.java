package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRepository {
	private static CarRepository instance;
	private final List<Car> cars = new ArrayList<>();

	public static CarRepository getInstance() {
		if (instance == null) {
			instance = new CarRepository();
		}
		return instance;
	}

	public void save(Car car) {
		cars.add(car);
	}

	public void clear() {
		cars.clear();
	}

	public void move(List<Integer> randoms) {
		IntStream.range(0, randoms.size())
			.forEach(i -> cars.get(i).move(randoms.get(i)));
	}

	public int getSize() {
		return cars.size();
	}

	public List<CarDto> getCars() {
		return carsToCarDtos(cars);
	}

	public List<CarDto> getWinners() {
		List<Car> winnerCars = cars.stream()
			.filter(car -> car.isSamePosition(getMaxPosition()))
			.collect(Collectors.toList());
		return carsToCarDtos(winnerCars);
	}

	private List<CarDto> carsToCarDtos(List<Car> cars) {
		return cars.stream()
			.map(Car::toCarDto)
			.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = car.getBiggerPosition(maxPosition);
		}
		return maxPosition;
	}
}
