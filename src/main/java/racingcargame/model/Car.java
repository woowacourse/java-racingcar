package racingcargame.model;

import racingcargame.utils.RandomNumberGenerator;

public class Car {
	private static final int MIN_MOVE_NUMBER = 4;
	private static final int MAX_NAME_LENGTH_COUNT = 5;
	private static final int MIN_NAME_LENGTH_COUNT = 1;
	private static final String BLANK = " ";
	private static final String HAS_BLANK_IN_NAMES_ERROR_MESSAGE = "[error] 입력한 자동차 이름에 공백이 있습니다.";
	private static final String NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE = "[error] 자동차 이름을 5자 이하로 입력해주세요.";

	private final String name;
	private int position;

	public Car(final String name, final int position) {
		checkValidateName(name);
		this.name = name;
		this.position = position;
	}

	public static String checkValidateName(final String name) {
		if (!hasBlankInNames(name) && isValidNameLength(name)) {
			return name;
		}
		throw new IllegalArgumentException();
	}

	private static boolean hasBlankInNames(final String name) {
		if (name.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_IN_NAMES_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isValidNameLength(final String name) {
		if (name.length() < MIN_NAME_LENGTH_COUNT || name.length() > MAX_NAME_LENGTH_COUNT) {
			throw new IllegalArgumentException(NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
		}
		return true;
	}

	String getName() {
		return name;
	}

	int getPosition() {
		return position;
	}

	int moveCar() {
		int moveNumber = pickMoveNumber();
		if (moveNumber >= MIN_MOVE_NUMBER) {
			position++;
		}
		return moveNumber;
	}

	private int pickMoveNumber() {
		return RandomNumberGenerator.pickRandomNumber();
	}
}
