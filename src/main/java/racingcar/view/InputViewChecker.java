package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;

public class InputViewChecker {
	private static final String ERROR_NULL = "[ERROR] 입력값은 NULL일 수 없습니다.";
	private static final String ERROR_BLANK = "[ERROR] 입력값은 빈 입력일 수 없습니다.";
	private static final String ERROR_SIZE = "[ERROR] 입력값의 크기는 5 초과일 수 없습니다.";
	private static final String ERROR_SPECIAL_CHAR = "[ERROR] 입력값은 특수문자일 수 없습니다.";
	private static final String ERROR_DUPLICATE = "[ERROR] 입력값은 중복될 수 없습니다.";
	private static final String ERROR_INT_NUM = "[ERROR] 입력값은 문자일 수 없습니다.";
	private static final String ERROR_NO_CAR = "[ERROR] 쉼표를 기준으로 차가 한 대 이상 있어야 합니다.";
	private static final String DELIMITER = ",";
	private static final String NUMBER_REGEX_PATTERN = "^[0-9]+$";
	private static final String NAME_REGEX_PATTERN = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$";
	private static final int SIZE_BOUND = 5;

	private static void checkNull(String stringInput) throws IllegalArgumentException {
		if (stringInput == null) {
			throw new IllegalArgumentException(ERROR_NULL);
		}
	}

	private static void checkBlank(String stringInput) throws IllegalArgumentException {
		if (stringInput.isEmpty()) {
			throw new IllegalArgumentException(ERROR_BLANK);
		}
	}

	private static void checkOverSize(String[] splitStringInput) throws IllegalArgumentException {
		boolean isOverSize = Arrays.stream(splitStringInput)
			.anyMatch(eachStringInput -> eachStringInput.length() > SIZE_BOUND);

		if (isOverSize) {
			throw new IllegalArgumentException(ERROR_SIZE);
		}
	}

	private static void checkZeroCars(String[] splitStringInput) throws IllegalArgumentException {
		if (Arrays.asList(splitStringInput).isEmpty()) {
			throw new IllegalArgumentException(ERROR_NO_CAR);
		}
	}

	private static void checkSpecialChar(String[] splitStringInput) throws IllegalArgumentException {
		boolean isSpecialCharError = Arrays.stream(splitStringInput)
			.anyMatch(eachStringInput -> !eachStringInput.matches(NAME_REGEX_PATTERN));
		if (isSpecialCharError) {
			throw new IllegalArgumentException(ERROR_SPECIAL_CHAR);
		}
	}

	private static void checkDuplicate(String[] splitStringInput) throws IllegalArgumentException {
		HashSet<String> nameSet = new HashSet<>(Arrays.asList(splitStringInput));
		if (nameSet.size() != splitStringInput.length) {
			throw new IllegalArgumentException(ERROR_DUPLICATE);
		}
	}

	private static void checkIntNum(String stringInput) throws IllegalArgumentException {
		if (!stringInput.matches(NUMBER_REGEX_PATTERN)) {
			throw new IllegalArgumentException(ERROR_INT_NUM);
		}
	}

	private static void nullOrBlank(String stringInput) throws IllegalArgumentException {
		checkNull(stringInput);
		checkBlank(stringInput);
	}

	private static void checkNameError(String nameInput) throws IllegalArgumentException {
		nullOrBlank(nameInput);
		String[] commaSeparateName = nameInput.split(DELIMITER);
		checkZeroCars(commaSeparateName);
		checkSpecialChar(commaSeparateName);
		checkOverSize(commaSeparateName);
		checkDuplicate(commaSeparateName);
	}

	private static void checkTurnError(String turnInput) throws IllegalArgumentException {
		nullOrBlank(turnInput);
		checkIntNum(turnInput);
	}

	public static String[] checkNameInput(final String userInput) throws IllegalArgumentException {
		checkNameError(userInput);
		return userInput.split(DELIMITER);
	}

	public static int checkTurnInput(final String userInput) throws IllegalArgumentException {
		checkTurnError(userInput);
		return Integer.parseInt(userInput);
	}
}
