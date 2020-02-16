package racingcar.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputUtil {
	private static final String SPACE = " ";
	private static final String EMPTY = "";
	private static final String COMMA = ",";
	private static final int LIMIT = -1;

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static List<String> inputCars() throws IOException {
		String input = bufferedReader.readLine();
		List<String> carsName = Arrays.asList(
			input.replace(SPACE, EMPTY)
				.split(COMMA, LIMIT));

		return carsName;
	}

	public static String inputRaceCount() throws IOException {
		return bufferedReader.readLine();
	}
}
