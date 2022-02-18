package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
import racingcar.domain.CarDto;
import racingcar.domain.Round;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	private static final int START_ROUND = 1;

	private final RacingService racingService = new RacingService();

	public void start() {
		racingService.registerCars(InputView.getCars());

		AttemptNumber attemptNumber = inputAttemptNumber();
		OutputView.printResultMessage();
		play(attemptNumber);

		printRacingRoundResult(attemptNumber);
		printRacingWinnerResult();
	}

	private AttemptNumber inputAttemptNumber() {
		String attemptNumberInput = InputView.getAttemptNumber();
		return AttemptNumber.of(attemptNumberInput);
	}

	private void play(AttemptNumber attemptNumber) {
		racingService.race(attemptNumber);
	}

	private void printRacingRoundResult(AttemptNumber attemptNumber) {
		for (int round = START_ROUND; round <= attemptNumber.value(); round++) {
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
