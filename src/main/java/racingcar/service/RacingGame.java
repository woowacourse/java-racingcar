package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;
import racingcar.domain.Round;
import racingcar.service.dto.CarDto;
import racingcar.util.MovingNumberPolicy;

public class RacingGame {

	private final Cars cars = new Cars();
	private final AttemptNumber attemptNumber;
	private final RacingResult racingResult = new RacingResult();

	private RacingGame(List<Car> cars, AttemptNumber attemptNumber) {
		this.cars.add(cars);
		this.attemptNumber = attemptNumber;
	}

	public static RacingGame of(List<CarDto> carDtos, AttemptNumber attemptNumber) {
		List<Car> cars = carDtos.stream()
			.map(CarDto::toEntity)
			.collect(Collectors.toList());
		return new RacingGame(cars, attemptNumber);
	}

	public void start(MovingNumberPolicy movingNumberPolicy) {
		for (int i = 0; i < attemptNumber.value(); i++) {
			playRound(movingNumberPolicy);
		}
	}

	public List<CarDto> findWinnerCars() {
		return cars.findWinnerCars().stream()
			.map(CarDto::of)
			.collect(Collectors.toList());
	}

	private void playRound(MovingNumberPolicy movingNumberPolicy) {
		cars.moveCars(movingNumberPolicy);
		racingResult.add(cars.findCars().stream()
			.map(Car::copy)
			.collect(Collectors.toList()));
	}

	public List<CarDto> findRacingResult(Round round) {
		return racingResult.findResult(round).stream()
			.map(CarDto::of)
			.collect(Collectors.toList());
	}
}
