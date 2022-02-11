package racingCar.view;

import java.util.Scanner;

import racingCar.utlis.Constants;

public class Input {

	public static String inputNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Constants.REQUEST_NAMES_MESSAGE);
		return scanner.next();
	}

	public static String inputCount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Constants.REQUEST_COUNT_MESSAGE);
		return scanner.next();
	}

}
