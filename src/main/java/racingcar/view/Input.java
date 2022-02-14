package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.validator.Validator;

import java.util.Scanner;

public class Input {
	private static final String DELIMITER = ",";

	private final Scanner scan = new Scanner(System.in);

	public Cars carName() {
		try {
			Output.getCarName();
			String inputValue = scan.nextLine();
			Validator.carName(inputValue);
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
}
