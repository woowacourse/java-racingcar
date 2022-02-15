package racingcar.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarDto;

public class CarRepository {

	private static CarRepository carRepository;
	private static final List<Car> cars = new ArrayList<>();

	private static final int FIRST_CAR = 0;
	private static final String EMPTY_CAR_ERROR_MESSAGE = "등록된 자동차가 없습니다.";

	private CarRepository() {}

	public static CarRepository getInstance() {
		if (carRepository == null) {
			carRepository = new CarRepository();
		}
		return carRepository;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public int count() {
		return cars.size();
	}

	public List<Car> findCars() {
		return new ArrayList<>(cars);
	}

	public void clear() {
		cars.clear();
	}

	public List<Car> findMaxPositionCars() {
		List<Car> sortedCars = findCars().stream()
			.sorted()
			.collect(Collectors.toList());

		Car maxPositionCar = sortedCars.get(FIRST_CAR);

		return sortedCars.stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.collect(Collectors.toList());
	}
}
