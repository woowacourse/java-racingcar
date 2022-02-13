package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.repository.CarRepository;
import racingcar.util.RandomUtil;

public class RacingService {

	private static final int RANDOM_VALUE_RANGE = 10;

	private static final CarRepository carRepository = new CarRepository();

	public List<Car> registerCars(List<String> carNames) {
		carNames.forEach(carName -> {
			carRepository.addCar(Car.of(carName));
		});
		return carRepository.findCars();
	}

	public void race(RandomUtil randomUtil) {
		List<Car> cars = carRepository.findCars();
		cars.forEach(car -> car.move(randomUtil.generate(RANDOM_VALUE_RANGE)));
	}

	public List<CarDto> findWinnerCars() {
		return carRepository.findWinnerCars().stream()
			.map(Car::toDto)
			.collect(Collectors.toList());
	}
}
