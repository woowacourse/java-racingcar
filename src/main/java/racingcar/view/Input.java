package racingcar.view;

import java.util.Scanner;

public class Input {

	private final Scanner scan = new Scanner(System.in);

	public String carName() {
		try {
			Output.getCarName();
			return inputText();
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return carName();
		}
	}

	public String attempt() {
		try {
			Output.getAttempt();
			return inputText();
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return attempt();
		}
	}

	private String inputText() {
		return scan.nextLine();
	}
}
