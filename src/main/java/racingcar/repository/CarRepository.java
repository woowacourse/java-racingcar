package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class CarRepository {

	private static final String EMPTY_CAR_ERROR_MESSAGE = "등록된 자동차가 없습니다.";
	public static final String EXIST_SAME_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 중복되면 안됩니다.";

	private static CarRepository carRepository;
	private static final List<Car> cars = new ArrayList<>();

	private CarRepository() {}

	public static CarRepository getInstance() {
		if (carRepository == null) {
			carRepository = new CarRepository();
		}
		return carRepository;
	}

	public void addCar(Car car) {
		validateDuplicateCarName(car);
		cars.add(car);
	}

	private void validateDuplicateCarName(Car car) {
		if (cars.contains(car)) {
			throw new IllegalStateException(EXIST_SAME_CAR_NAME_ERROR_MESSAGE);
		}
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
		Car maxPositionCar = findMaxPositionCar();

		return findCars().stream()
			.filter(car -> car.isSamePosition(maxPositionCar))
			.collect(Collectors.toList());
	}

	private Car findMaxPositionCar() {
		return findCars().stream()
			.max(Car::compareTo)
			.orElseThrow(() -> {
				throw new IllegalStateException(EMPTY_CAR_ERROR_MESSAGE);
			});
	}
}
