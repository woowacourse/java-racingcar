package carracing.view;

import static carracing.view.messages.ExceptionMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import carracing.view.messages.ExceptionMessage;

public class InputView {
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static String getCarNames() {
		String line = "";
		try {
			line = bufferedReader.readLine();
			validateEmptyString(line);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e.getMessage());
			getCarNames();
		}
		return line;
	}

	public static int getNumberOfGames() {
		String line = "";
		int numberOfGames = 0;
		try {
			line = bufferedReader.readLine();
			validateEmptyString(line);
			validateNumber(line);
			numberOfGames = toInt(line);
			validateZero(numberOfGames);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e.getMessage());
			getNumberOfGames();
		}
		return numberOfGames;
	}

	private static int toInt(String line) {
		return Integer.parseInt(line);
	}

	private static void validateZero(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(INPUT_NUMBER_ZERO_EXCEPTION.getMessage());
		}
	}

	private static void validateEmptyString(String line) {
		if (line.isEmpty()) {
			throw new IllegalArgumentException(INPUT_EMPTY_STRING_EXCEPTION.getMessage());
		}
	}

	public static void validateNumber(String line) {
		if(!line.matches("^[0-9]+$")){
			throw new IllegalArgumentException(INPUT_NOT_NUMBER_EXCEPTION.getMessage());
		}
	}

}
