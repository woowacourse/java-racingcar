package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
	private static final int ATTEMPT_LIMIT = 0;
	private static final String CARS_ERROR_MESSAGE = "자동차를 두 개 이상 입력해주세요.";
	private static final String DELIMITER = ",";
	private static final String NULL_ERROR = "null";
	private static final String EMPTY_ERROR = "공백";
	private static final String CAR_BLANK_ERROR_MESSAGE = "자동차 이름은 %s일 수 없습니다.";
	private static final String CAR_DUPLICATED_ERROR_MESSAGE = "자동차 이름을 모두 다르게 입력해주세요.";
	private static final String ATTEMPT_BLANK_ERROR_MESSAGE = "반복 횟수는 %s일 수 없습니다.";
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";
	private static final String ATTEMPT_NUMERIC_ERROR_MESSAGE = "시도횟수는 숫자를 입력해주세요.";
	private static final String ATTEMPT_NEGATIVE_ERROR_MESSAGE = "시도횟수는 1이상의 수를 입력해주세요.";
	private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";
	private static final int CAR_LIMIT = 2;
	private static final int CAR_LENGTH_LIMIT = 5;
	private static final String EMPTY = "";

	private final Scanner scan = new Scanner(System.in);

	public Cars carName() {
		try {
			Output.getCarName();
			String inputValue = scan.nextLine();
			allCarsValid(inputValue);
			return new Cars(
				inputValue.split(DELIMITER));
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return carName();
		}
	}

	public Attempt attempt() {
		try {
			Output.getAttempt();
			String inputValue = scan.nextLine();
			attemptValid(inputValue);
			return new Attempt(Integer.parseInt(inputValue));
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return attempt();
		}
	}

	public void allCarsValid(String names) {
		checkBlank(names, CAR_BLANK_ERROR_MESSAGE);
		String[] cars = names.split(DELIMITER);
		if (!isCars(cars)) {
			throw new IllegalArgumentException(CARS_ERROR_MESSAGE);
		}
		if (isDuplicated(cars)) {
			throw new IllegalArgumentException(CAR_DUPLICATED_ERROR_MESSAGE);
		}
		nameValid(cars);
	}

	private void nameValid(String[] cars) {
		for (String name : cars) {
			checkBlank(name, CAR_BLANK_ERROR_MESSAGE);
			validLength(name);
		}
	}

	public void checkBlank(String name, String text) {
		if (name == null) {
			throw new NullPointerException(String.format(text, NULL_ERROR));
		}
		if (name.trim().equals(EMPTY)) {
			throw new IllegalArgumentException(String.format(text, EMPTY_ERROR));
		}
	}

	public boolean isCars(String[] names) {
		return names.length >= CAR_LIMIT;
	}

	public boolean isDuplicated(String[] names) {
		Set<String> carNames = new HashSet<>(Arrays.asList(names));
		return carNames.size() != names.length;
	}

	public void validLength(String name) {
		if (!(name.trim().length() <= CAR_LENGTH_LIMIT)) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}

	private void attemptValid(String attempt) {
		if (attempt.isBlank()) {
			throw new IllegalArgumentException(ATTEMPT_BLANK_ERROR_MESSAGE);
		}
		if (!isNumber(attempt)) {
			throw new IllegalArgumentException(ATTEMPT_NUMERIC_ERROR_MESSAGE);
		}
		if (isNegative(attempt)) {
			throw new IllegalArgumentException(ATTEMPT_NEGATIVE_ERROR_MESSAGE);
		}
	}

	public boolean isNumber(String string) {
		return string.matches(NUMBER_REGEX);
	}

	public boolean isNegative(String string) {
		int attempt = Integer.parseInt(string);
		return attempt <= ATTEMPT_LIMIT;
	}
}
