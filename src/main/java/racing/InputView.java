package racing;

import java.util.Arrays;
import java.util.List;

public class InputView {
	public static List<String> splitAsComma(String value) {
		return Arrays.asList(value.split(","));
	}

	public static boolean checkMaxLength(List<String> input) {
		return input.stream().allMatch(x -> x.length() <= 5);
	}
}
