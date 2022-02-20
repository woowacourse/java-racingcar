package racingcar.view;

import java.util.Scanner;

public class UserInputView {
	public String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
