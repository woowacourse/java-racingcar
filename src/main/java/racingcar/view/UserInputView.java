package racingcar.view;

import java.util.Scanner;

public class UserInputView {
	private String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public String[] getNameInput() {
		return InputViewChecker.checkNameInput(getUserInput());
	}

	public int getTurnInput() {
		return InputViewChecker.checkTurnInput(getUserInput());
	}
}
