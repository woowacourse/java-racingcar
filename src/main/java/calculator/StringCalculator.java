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

	}

	private static boolean isNullOrEmpty(String input) {
		return input.isBlank() || input == null;
	}

	private static boolean isNumeric(String str) {
		return str.matches("^(0|[1-9][0-9]*)$");
	}

}
