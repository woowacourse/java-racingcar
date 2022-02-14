package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
	private static final String DELIMITER = ",";
	private static final int CAR_LIMIT = 2;
	private static final int CAR_LENGTH_LIMIT = 5;

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
			Validator.attempt(inputValue);
			return new Attempt(Integer.parseInt(inputValue));
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return attempt();
		}
	}

	public void allCarsValid(String names) {
		checkBlank(names, "자동차 이름은 %s일 수 없습니다.");
		String[] cars = names.split(DELIMITER);
		if (!isCars(cars)) {
			throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
		}
		if (isDuplicated(cars)) {
			throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
		}
		nameValid(cars);
	}

	private void nameValid(String[] cars) {
		for (String name : cars) {
			checkBlank(name, "자동차 이름은 %s일 수 없습니다.");
			validLength(name);
		}
	}

	public void checkBlank(String name, String text) {
		if (name == null) {
			throw new NullPointerException(String.format(text, "null"));
		}
		if (name.trim().equals("")) {
			throw new IllegalArgumentException(String.format(text, "공백"));
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
			throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
		}
	}
}
