package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;

import java.util.Scanner;

public class Input {
	private static final String DELIMITER = ",";
	private static final Scanner scan = new Scanner(System.in);

	private Input() {
	}

	public static Cars carName() {
		try {
			Output.carNameGuide();
			String inputValue = scan.nextLine();
			String[] names = inputValue.split(DELIMITER);
			return new Cars(names);
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return carName();
		}
	}

	public static Attempt attempt() {
		try {
			Output.attemptGuide();
			String inputValue = scan.nextLine();
			return new Attempt(inputValue);
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return attempt();
		}
	}
}
