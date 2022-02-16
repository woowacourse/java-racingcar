package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Attempt;
import racingcar.domain.CarDto;
import racingcar.domain.Round;
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

		printRacingRoundResult(attempt);
		printRacingWinnerResult();
	}

	private Attempt inputAttempt() {
		String attemptNumberInput = InputView.getAttemptNumber();
		return Attempt.fromStringValue(attemptNumberInput);
	}

	private void play(Attempt attempt) {
		racingService.race(attempt);
	}

	private void printRacingRoundResult(Attempt attempt) {
		for (int round = 1; round <= attempt.getNumber(); round++) {
			List<CarDto> racingResult = racingService.findRacingResult(Round.of(round));
			OutputView.printRacingInfo(racingResult);
		}
	}

	private void printRacingWinnerResult() {
		List<String> winnerNames = racingService.findWinnerCars().stream()
			.map(CarDto::getName)
			.collect(Collectors.toList());

		OutputView.printWinnersMessage(winnerNames);
	}
}
