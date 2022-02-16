package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.repository.CarRepository;
import racingcar.util.RandomUtilImpl;

public class RacingService {

	private final CarRepository carRepository = new CarRepository();
	private final RandomUtilImpl randomUtil = new RandomUtilImpl();
	private RacingGame racingGame;

	public void registerCars(List<CarDto> carDtos) {
		List<Car> cars = carDtos.stream()
			.map(CarDto::toEntity)
			.collect(Collectors.toList());

		carRepository.add(cars);
	}

	public void race(Attempt attempt) {
		racingGame = RacingGame.of(carRepository.findCars(), attempt);
		List<Car> resultCars = racingGame.start(randomUtil);
		carRepository.updateCars(resultCars);
	}

	public List<CarDto> findRacingResult(Round round) {
		return racingGame.findResultCars(round).stream()
			.map(Car::toDto)
			.collect(Collectors.toList());
	}

	public List<CarDto> findWinnerCars() {
		return carRepository.findWinnerCars().stream()
			.map(Car::toDto)
			.collect(Collectors.toList());
	}
}
