package racingcar.service;

public class CheckingService {
	private static final String NULL_EMPTY_CAR_NAME_ERROR_MESSAGE = "[Error] 다시 이름을 입력하세요";
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = String.format("[Error] %d자 이하의 이름을 입력하세요.",
		MAX_CAR_NAME_LENGTH);
	private static final String GAME_TURN_NUMBER_ERROR_MESSAGE = "[Error] 숫자를 입력하세요.";
	private static final String GAME_TURN_NUMBER_REGEX = "[1-9]\\d*";

	public static void checkCarNamesBlank(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException(NULL_EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
	}

	public static void checkCarNameLength(String carName) {
		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	public static void checkGameTurnNumber(String gameTurn) {
		if (!gameTurn.matches(GAME_TURN_NUMBER_REGEX)) {
			throw new IllegalArgumentException(GAME_TURN_NUMBER_ERROR_MESSAGE);
		}
	}
}
