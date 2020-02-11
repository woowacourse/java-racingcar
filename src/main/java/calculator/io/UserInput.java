package calculator.io;

import java.util.Scanner;

public class UserInput {
	private static final Scanner sc = new Scanner(System.in);

	public static String getInput() {
		return sc.nextLine();
	}
}
