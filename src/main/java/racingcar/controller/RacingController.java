package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.Converter;
import racingcar.util.RandomUtilImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

	private final RacingService racingService = new RacingService();
	private final RandomUtilImpl randomUtil = new RandomUtilImpl();

	private static final String ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";
	private static final int MINIMUM_ATTEMPT_NUMBER = 1;

	public void start() {
		inputAndRegisterCarInfo();
		int attemptNumber = InputView.getAttemptNumber();

		OutputView.printResultMessage();
		play(attemptNumber);
		printRacingResult();
	}

	private void inputAndRegisterCarInfo() {
		String carNames = InputView.getCarNames();
		racingService.registerCars(Converter.toCarList(carNames));
	}

	private void play(int attemptNumber) {
		validateAttemptNumberRange(attemptNumber);

		for (int i = 0; i < attemptNumber; i++) {
			racingService.race(randomUtil);
			OutputView.printRacingInfo(racingService.findCarDtos());
		}
	}

	private void validateAttemptNumberRange(int attemptNumber) {
		if (attemptNumber < MINIMUM_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	private void printRacingResult() {
		List<String> winnerNames = racingService.findWinnerNames();
		OutputView.printWinnersMessage(winnerNames);
	}

}
