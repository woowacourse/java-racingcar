package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.CarNameValidator;
import racingcar.domain.Cars;
import racingcar.domain.RacingRecordDTO;
import racingcar.domain.WinnerNames;
import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	private static final String CAR_NAME_DELIMITER = ",";
	private static final int MAX_BOUND = 9;
	private static final int MIN_BOUND = 0;

	public final RandomNumberGenerator randomNumberGenerator;

	public RacingCarController() {
		this.randomNumberGenerator = new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND);
	}

	public void playGame() {
		Cars cars = new Cars(splitAndGetCarNames(InputView.getCarNames()));
		int trialCount = InputView.getTrialCount();

		OutputView.printRacingRecordsMsg();
		for (int i = 0; i < trialCount; i++) {
			cars.executeCarRacing(randomNumberGenerator);
			OutputView.printRacingRecords(new RacingRecordDTO(cars.getRacingRecord()));
		}

		OutputView.printWinnerNames(new WinnerNames().findWinners(cars.getCars()));
	}

	private List<String> splitAndGetCarNames(String carNamesLine) {
		List<String> carNames = Arrays.asList(carNamesLine.split(CAR_NAME_DELIMITER, -1));
		CarNameValidator.checkEachCarNames(carNames);
		return carNames;
	}
}
