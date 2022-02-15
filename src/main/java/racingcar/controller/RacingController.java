package racingcar.controller;

import java.util.List;

import racingcar.domain.RacingResult;
import racingcar.service.RacingService;
import racingcar.util.Converter;
import racingcar.util.RandomUtilImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	private final RacingService racingService = new RacingService(new RandomUtilImpl());

	public void start() {
		String carNames = InputView.getCarNames();
		racingService.registerCars(Converter.toCarList(carNames));

		int attemptNumber = InputView.getAttemptNumber();

		RacingResult racingResult = racingService.race(attemptNumber);

		printRacingResult(racingResult);
	}

	private void printRacingResult(RacingResult racingResult) {
		OutputView.printResultMessage();

		racingResult.get().stream()
			.forEach(OutputView::printRacingInfo);

		List<String> winnerNames = racingService.findWinnerNames();
		OutputView.printWinnersMessage(winnerNames);
	}

}
