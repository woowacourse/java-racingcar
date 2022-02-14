package racingcargame.controller;

import java.util.List;
import java.util.Scanner;

import racingcargame.utils.RaceCountInputValidator;

public class InputController {
	private static final String SEPARATOR = ",";
	private static final String NOTHING_INPUT_IN_CAR_NAMES_ERROR_MESSAGE = "[error] 입력된 자동차 이름이 없습니다.";

	private static final InputController inputController = new InputController();
	private static final Scanner scanner = new Scanner(System.in);

	private InputController() {
	}

	public static InputController getInputController() {
		return inputController;
	}

	public List<String> inputRacingCarNames() {
		String racingCarNames = checkNothingInputInCarNames(scanner.nextLine());
		return List.of((racingCarNames).split(SEPARATOR));
	}

	private static String checkNothingInputInCarNames(final String carNames) {
		if (carNames == null) {
			throw new IllegalArgumentException(NOTHING_INPUT_IN_CAR_NAMES_ERROR_MESSAGE);
		}
		return carNames;
	}

	public int inputRaceCount() {
		String raceCount = scanner.nextLine();
		return Integer.parseInt(RaceCountInputValidator.validateRaceCount(raceCount));
	}
}
