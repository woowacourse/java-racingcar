package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.AttemptNumber;
import racingcar.domain.CarDto;
import racingcar.domain.Round;
import racingcar.service.RacingGame;
import racingcar.util.MovingNumberPolicyByRandom;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	private static final int START_ROUND = 1;

	public void start() {
		final List<CarDto> cars = InputView.getCars();
		final AttemptNumber attemptNumber = inputAttemptNumber();

		final RacingGame racingGame = RacingGame.of(cars, attemptNumber);
		racingGame.start(new MovingNumberPolicyByRandom());

		printRacingResult(racingGame, attemptNumber);
		printRacingWinnerResult(racingGame);
	}

	private AttemptNumber inputAttemptNumber() {
		String attemptNumberInput = InputView.getAttemptNumber();
		return AttemptNumber.of(attemptNumberInput);
	}

	private void printRacingResult(RacingGame racingGame, AttemptNumber attemptNumber) {
		OutputView.printResultMessage();

		for (int round = START_ROUND; round <= attemptNumber.value(); round++) {
			List<CarDto> racingResult = racingGame.findRacingResult(Round.of(round));
			OutputView.printRacingInfo(racingResult);
		}
	}

	private void printRacingWinnerResult(RacingGame racingGame) {
		List<String> winnerNames = racingGame.findWinnerCars().stream()
			.map(CarDto::getName)
			.collect(Collectors.toList());

		OutputView.printWinnersMessage(winnerNames);
	}
}
