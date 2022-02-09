package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StringCalculator {

	public static int calculate(String input) {
		if (isNullOrEmpty(input)) {
			return 0;
		}
		if(isNumeric(input)){
			return Integer.parseInt(input);
		}
		String[] numStrArray = split(input);
	}

	private static boolean isNullOrEmpty(String input) {
		return input.isBlank() || input == null;
	}

	private static boolean isNumeric(String input) {
		return input.matches("^(0|[1-9][0-9]*)$");
	}

	private static String[] split(String input) {
		List<String> delimiters = new ArrayList<>();
		delimiters.add(",");
		delimiters.add(":");

		if(input.contains("//") && input.contains("\n")){
			String customDelimiter = input.substring(input.indexOf("//") + 2, input.indexOf("\n"));
			delimiters.add(customDelimiter);
			input = input.substring(input.indexOf("\n") + 1);
		}
		String delimiter = String.join("|", delimiters);
		return input.split(delimiter);
	}
}
