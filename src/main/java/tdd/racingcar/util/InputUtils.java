package tdd.racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputUtils {
	private static final String COMMA = ",";

	public static List<String> splitByComma(final String input) {
		return Arrays.asList(input.split(COMMA));
	}
}
