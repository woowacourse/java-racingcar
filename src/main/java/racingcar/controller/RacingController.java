package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.RandomUtilImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	private final RacingService racingService = new RacingService();
	private final RandomUtilImpl randomUtil = new RandomUtilImpl();

	public void start() {
		List<Car> cars = inputAndRegisterCarInfo();
		int attemptNumber = InputView.getAttemptNumber();

		OutputView.printResultMessage();
		play(attemptNumber, cars);
		printRacingResult();
	}

	private List<Car> inputAndRegisterCarInfo() {
		List<Car> cars = InputView.getCarNames();
		racingService.registerCars(cars);
		return cars;
	}

	private void play(int attemptNumber, List<Car> cars) {
		for (int i = 0; i < attemptNumber; i++) {
			racingService.race(randomUtil);
			OutputView.printRacingInfo(cars.stream()
				.map(Car::toDto)
				.collect(Collectors.toList())
			);
		}
	}

	private void printRacingResult() {
		List<String> winnerNames = racingService.findWinnerNames();
		OutputView.printWinnersMessage(winnerNames);
	}

}
