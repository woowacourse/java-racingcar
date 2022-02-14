package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.domain.validation.CarValidator;
import racingcar.domain.validation.Validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
	private static final String DELIMITER = ",";
	private static final String CAR_BLANK_ERROR_MESSAGE = "자동차 이름은 %s일 수 없습니다.";

	private final Scanner scan = new Scanner(System.in);
	private final Validator validator = new Validator();

	public Cars carName() {
		try {
			Output.getCarName();
			String inputValue = scan.nextLine();
			validator.checkBlank(inputValue, CAR_BLANK_ERROR_MESSAGE);
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
			return new Attempt(inputValue);
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return attempt();
		}
	}
}
