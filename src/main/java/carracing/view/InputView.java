package carracing.view;

import static carracing.view.messages.ExceptionMessage.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static final Pattern VALIDATE_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
	private static final String DELIMITER_REGEX = ",";

	private InputView() { }

	public static List<String> getCarNames() {
		List<String> carNames = new ArrayList<>();
		String line = "";
		try {
			line = inputString();
			validateEmptyString(line);
			carNames = splitCarNames(line);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e.getMessage());
			getCarNames();
		}
		return carNames;
	}

	public static int getNumberOfGames() {
		int numberOfGames;
		try {
			String line = inputString();
			validateEmptyString(line);
			validateNumber(line);
			numberOfGames = toInt(line);
			validateZero(numberOfGames);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e.getMessage());
			numberOfGames = getNumberOfGames();
		}
		return numberOfGames;
	}

	private static String inputString() throws IOException {
		return bufferedReader.readLine();
	}

	private static void validateEmptyString(String line) {
		if (line.isEmpty()) {
			throw new IllegalArgumentException(INPUT_EMPTY_STRING_EXCEPTION.getMessage());
		}
	}

	private static List<String> splitCarNames(String line) {
		return Arrays.asList(line.split(DELIMITER_REGEX));
	}

	private static void validateNumber(String line) {
		if (isNumber(line)) {
			throw new IllegalArgumentException(INPUT_NOT_NUMBER_EXCEPTION.getMessage());
		}
	}

	private static boolean isNumber(String line) {
		return !VALIDATE_NUMBER_PATTERN.matcher(line).matches();
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
