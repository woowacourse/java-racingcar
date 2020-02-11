package tdd.racingcar;

import java.util.Arrays;
import java.util.List;

public class InputUtils {
	private static final String COMMA = ",";

	public static List<String> splitByComma(String input) {
		return Arrays.asList(input.split(COMMA));
	}
}
