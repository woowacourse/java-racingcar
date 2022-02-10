package carracing.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static String readLine() {
		String line = "";
		try {
			line = bufferedReader.readLine();
			validateEmptyString(line);
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e.getMessage());
			readLine();
		}
		return line;
	}

	private static void validateEmptyString(String line) {
		if (line.isEmpty()) {
			throw new IllegalArgumentException("빈 문자열을 입력하면 안됩니다.");
		}
	}
}
