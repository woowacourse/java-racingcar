package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class carsNameSpliter {
	private static final String SPACE = " ";
	private static final String EMPTY = "";
	private static final String COMMA = ",";
	private static final int LIMIT = -1;


	public static List<String> split(String carsName) {
		return Arrays.asList(
				carsName.replace(SPACE, EMPTY)
						.split(COMMA, LIMIT));

	}
}
