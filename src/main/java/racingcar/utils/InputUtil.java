package racingcar.utils;

import racingcar.domain.Cars;
import racingcar.domain.RaceCount;

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

	public static Cars createCarsByInput() throws IOException {
		String input = bufferedReader.readLine();
		List<String> carsName = Arrays.asList(
				input.replace(SPACE, EMPTY)
				.split(COMMA, LIMIT));

		return new Cars(carsName);
	}

	public static RaceCount createRaceCountByInput() throws IOException {
		return new RaceCount(bufferedReader.readLine());
	}
}
