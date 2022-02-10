package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
	private static CarRepository instance;
	private final List<Car> cars = new ArrayList<>();
	private final RandomNo randomNo = new RandomNo();

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

	public void move() {
		cars.forEach(car -> car.move(randomNo.getNumber()));
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

	public List<CarDto> getCars() {
		return carsToCarDtos(cars);
	}
}
