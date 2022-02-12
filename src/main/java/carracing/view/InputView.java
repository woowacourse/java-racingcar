package carracing.view;

import static carracing.view.messages.ExceptionMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static final String VALIDATE_NUMBER_REGEX = "^[0-9]+$";

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
		int numberOfGames = 0;
		try {
			String line = bufferedReader.readLine();
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

	private static void validateEmptyString(String line) {
		if (line.isEmpty()) {
			throw new IllegalArgumentException(INPUT_EMPTY_STRING_EXCEPTION.getMessage());
		}
	}

	private static void validateNumber(String line) {
		if (!line.matches(VALIDATE_NUMBER_REGEX)) {
			throw new IllegalArgumentException(INPUT_NOT_NUMBER_EXCEPTION.getMessage());
		}
	}

	private static int toInt(String line) {
		return Integer.parseInt(line);
	}

	private static void validateZero(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(INPUT_NUMBER_ZERO_EXCEPTION.getMessage());
		}
	}
}
