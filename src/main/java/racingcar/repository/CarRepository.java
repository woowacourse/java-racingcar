package racingcar.repository;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarDto;

public class CarRepository {

	private static CarRepository carRepository;
	private static final List<Car> cars = new ArrayList<>();

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

	public int findMaxPosition() {
		return cars.stream()
			.map(Car::toDto)
			.mapToInt(CarDto::getPosition)
			.max()
			.orElseThrow(() -> new IllegalStateException(EMPTY_CAR_ERROR_MESSAGE));
	}

	public void clear() {
		cars.clear();
	}

}
