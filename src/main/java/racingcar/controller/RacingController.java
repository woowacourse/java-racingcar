package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Attempt;
import racingcar.domain.CarDto;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	private final RacingService racingService = new RacingService();

	public void start() {
		racingService.registerCars(InputView.getCars());

		Attempt attempt = inputAttempt();
		OutputView.printResultMessage();
		play(attempt);

		printRacingResult();
	}

	private Attempt inputAttempt() {
		String attemptNumberInput = InputView.getAttemptNumber();
		return new Attempt(attemptNumberInput);
	}

	private void play(Attempt attempt) {
		List<CarDto> carDtos = racingService.race(attempt);
		OutputView.printRacingInfo(carDtos);

	}

	private void printRacingResult() {
		List<String> winnerNames = racingService.findWinnerCars().stream()
			.map(CarDto::getName)
			.collect(Collectors.toList());

		OutputView.printWinnersMessage(winnerNames);
	}

}
