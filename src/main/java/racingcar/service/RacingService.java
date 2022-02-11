package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.repository.CarRepository;
import racingcar.util.RandomUtil;

public class RacingService {


	private static final CarRepository carRepository = new CarRepository();

	private static final int RANDOM_VALUE_RANGE = 10;
	public static final int MINIMUM_NUMBER_OF_RACE_POSSIBLE = 2;

	public void registerCars(List<Car> cars) {
		cars.forEach(carRepository::addCar);
	}

	public void race(RandomUtil randomUtil) {
		List<Car> cars = carRepository.findCars();
		validateRacePossible(cars);
		cars.forEach(car -> car.move(randomUtil.generate(RANDOM_VALUE_RANGE)));
	}

	private void validateRacePossible(List<Car> cars) {
		if (cars.size() < MINIMUM_NUMBER_OF_RACE_POSSIBLE) {
			throw new IllegalStateException();
		}
	}

	public List<CarDto> findCarDtos() {
		return carRepository.findCars().stream()
			.map(Car::toDto)
			.collect(Collectors.toList());
	}

	public List<String> findWinnerNames() {
		int maxPosition = carRepository.findMaxPosition();

		return carRepository.findCars().stream()
			.filter(car -> car.isSamePosition(maxPosition))
			.map(Car::toDto)
			.map(CarDto::getName)
			.collect(Collectors.toList());
	}
}
