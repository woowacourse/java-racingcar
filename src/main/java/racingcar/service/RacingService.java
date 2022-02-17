package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingResult;
import racingcar.repository.CarRepository;
import racingcar.util.MovingStrategy;

public class RacingService {

	private static final int MINIMUM_NUMBER_OF_RACE_POSSIBLE = 2;

	private static final String NUMBER_OF_CAR_ERROR_MESSAGE = "레이싱에 필요한 자동차 수는 2대 이상입니다.";

	private final CarRepository carRepository = CarRepository.getInstance();
	private final MovingStrategy movingStrategy;

	public RacingService(MovingStrategy movingStrategy) {
		this.movingStrategy = movingStrategy;
	}

	public void registerCars(List<Car> cars) {
		cars.forEach(carRepository::addCar);
	}

	public RacingResult race(AttemptNumber attemptNumber) {
		List<Car> cars = carRepository.findCars();
		validateRacePossible(cars);

		RacingResult racingResult = new RacingResult();

		int currentAttemptNumber = 1;

		do {
			cars.forEach(car -> car.move(movingStrategy.generate()));
			racingResult.addRecord(findCarDtos());
		} while (!attemptNumber.isSameNumber(currentAttemptNumber++));

		return racingResult;
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
