package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
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

	public void race(AttemptNumber attemptNumber) {
		racingGame = RacingGame.of(carRepository.findCars(), attemptNumber);
		List<Car> resultCars = racingGame.start(randomUtil);
		carRepository.updateCars(resultCars);
	}

	public List<CarDto> findRacingResult(Round round) {
		return racingGame.findResultCars(round).stream()
			.map(CarDto::of)
			.collect(Collectors.toList());
	}

	public List<CarDto> findWinnerCars() {
		return carRepository.findWinnerCars().stream()
			.map(CarDto::of)
			.collect(Collectors.toList());
	}
}
