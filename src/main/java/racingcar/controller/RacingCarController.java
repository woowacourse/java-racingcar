package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import racingcar.domain.CarStatusDTO;
import racingcar.domain.Cars;
import racingcar.domain.RacingRecordDTO;
import racingcar.domain.WinnerNames;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	public static final String CAR_NAME_DELIMITER = ",";
	public final WinnerNames winnerNames = new WinnerNames();

	public void playGame() {
		Cars cars = new Cars((getCarNames(InputView.inputCarNames())));
		int trialCount = getTrialCount(InputView.inputTrials());

		OutputView.printRacingRecordsMsg();
		for (int i = 0; i < trialCount; i++) {
			OutputView.printRacingRecords(new RacingRecordDTO(cars.executeCarRacing()));
		}

		OutputView.printWinnerNames(cars.findWinners(winnerNames));
	}

	public List<String> getCarNames(String carNamesLine) {
		CarNameValidator.checkCarNamesLine(carNamesLine);
		return split(carNamesLine);
	}

	public List<String> split(String carNamesLine) {
		List<String> carNames = Arrays.asList(carNamesLine.split(CAR_NAME_DELIMITER, -1));
		CarNameValidator.checkCarNames(carNames);
		return carNames;
	}

	public int getTrialCount(String line) {
		TrialCountValidator.checkTrialCountLine(line);
		return Integer.parseInt(line);
	}
}
