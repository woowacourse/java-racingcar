package carracing.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
		}
	}

	private static void validateEmptyString(String line) {
		if (line.isEmpty()) {
			throw new IllegalArgumentException("빈 문자열을 입력하면 안됩니다.");
		}
	}

	public static void validateNumber(String line) {
		if(!line.matches("^[0-9]+$")){
			throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
		}
	}

}
