package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.domain.Cars;
import racingcar.util.MovingNumberPolicyByRandom;

public class RacingService {

	private final Cars cars = new Cars();
	private final MovingNumberPolicyByRandom randomUtil = new MovingNumberPolicyByRandom();
	private RacingGame racingGame;

	public void registerCars(List<CarDto> carDtos) {
		List<Car> cars = carDtos.stream()
			.map(CarDto::toEntity)
			.collect(Collectors.toList());

		this.cars.add(cars);
	}

	public void race(AttemptNumber attemptNumber) {
		racingGame = RacingGame.of(cars.findCars(), attemptNumber);
		List<Car> resultCars = racingGame.start(randomUtil);
		cars.updateCars(resultCars);
	}

	public List<CarDto> findRacingResult(Round round) {
		return racingGame.findResultCars(round).stream()
			.map(CarDto::of)
			.collect(Collectors.toList());
	}

	public List<CarDto> findWinnerCars() {
		return cars.findWinnerCars().stream()
			.map(CarDto::of)
			.collect(Collectors.toList());
	}
}
