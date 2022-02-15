package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;

import java.util.Scanner;

public class Input {

	private final Scanner scan = new Scanner(System.in);

	public Cars carName() {
		try {
			Output.getCarName();
			String inputValue = scan.nextLine();
			return new Cars(inputValue);
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
