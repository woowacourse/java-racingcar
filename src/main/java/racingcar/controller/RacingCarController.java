package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Cars;
import racingcar.domain.WinnerNames;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public final Cars cars = new Cars();
	public final WinnerNames winnerNames = new WinnerNames();

	public void playGame() {
		cars.generateCars(getCarNames(InputView.inputCarNames()));
		int trialCount = getTrialCount(InputView.inputTrials());

		OutputView.printResultMessage();
		for (int i = 0; i < trialCount; i++) {
			OutputView.printRacingRecords(cars.executeCarRacing());
		}

		OutputView.printWinnerNames(cars.findWinners(winnerNames));
	}

	public List<String> getCarNames(String carNamesLine) {
		CarNameValidator.checkCarNamesLine(carNamesLine);
		return split(carNamesLine);
	}

	public List<String> split(String carNamesLine) {
		List<String> carNames = Arrays.asList(carNamesLine.split(","));
		CarNameValidator.checkCarNames(carNames);
		return carNames;
	}

	public int getTrialCount(String line) {
		TrialCountValidator.checkTrialCountLine(line);
		return Integer.parseInt(line);
	}
}
