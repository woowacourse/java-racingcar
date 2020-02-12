package racingcar.utils;

import racingcar.domain.Cars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputUtil {
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String COMMA = ",";
	public static final int LIMIT = -1;

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static Cars createCarsByInput() throws IOException {
		String input = bufferedReader.readLine();
		List<String> carsName = Arrays.asList(input.replace(SPACE, EMPTY)
				.split(COMMA, LIMIT));

		return new Cars(carsName);
	}
}
