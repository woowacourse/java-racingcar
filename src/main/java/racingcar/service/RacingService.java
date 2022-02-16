package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingResult;
import racingcar.repository.CarRepository;
import racingcar.util.MovingStrategy;

public class RacingService {

	private static final int MINIMUM_NUMBER_OF_RACE_POSSIBLE = 2;
	private static final int MINIMUM_ATTEMPT_NUMBER = 1;

	private static final String NUMBER_OF_CAR_ERROR_MESSAGE = "레이싱에 필요한 자동차 수는 2대 이상입니다.";
	private static final String ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";

	private final CarRepository carRepository = CarRepository.getInstance();
	private final MovingStrategy movingStrategy;

	public RacingService(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
	}

	public void registerCars(List<Car> cars) {
		cars.forEach(carRepository::addCar);
	}

	public RacingResult race(int attemptNumber) {
		validateAttemptNumberRange(attemptNumber);

		List<Car> cars = carRepository.findCars();
		validateRacePossible(cars);

		RacingResult racingResult = new RacingResult();

		for (int i = 0; i < attemptNumber; i++) {
			cars.forEach(car -> car.move(movingStrategy.generate()));
			racingResult.addRecord(findCarDtos());
		}

		return racingResult;
	}

	private void validateAttemptNumberRange(int attemptNumber) {
		if (attemptNumber < MINIMUM_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	private void validateRacePossible(List<Car> cars) {
		if (cars.size() < MINIMUM_NUMBER_OF_RACE_POSSIBLE) {
			throw new IllegalStateException(NUMBER_OF_CAR_ERROR_MESSAGE);
		}
	}

	public List<CarDto> findCarDtos() {
		return carRepository.findCars().stream()
			.map(Car::toDto)
			.collect(Collectors.toList());
	}

	public List<String> findWinnerNames() {
		return carRepository.findMaxPositionCars().stream()
			.map(Car::toDto)
			.map(CarDto::getName)
			.collect(Collectors.toList());
	}
}
