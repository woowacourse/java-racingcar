import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {
	public static int calculate(String input) {
		String regex = checkCustomRegex("", input);

		input = subStringInput(regex, input);

		return Stream.of(splitAsRegex(regex, input))
			.map(Integer::parseInt)
			.reduce(Integer::sum)
			.orElse(0);
	}

	private static String checkCustomRegex(String regex, String input) {
		Pattern p = Pattern.compile("//(.)\n");
		Matcher matcher = p.matcher(input);
		while (matcher.find()) {
			regex = matcher.group(1);
		}

		return regex;
	}

	private static String subStringInput(String regex, String input) {
		if (!regex.equals("")) {
			return input.substring(4);
		}

		return input;
	}

	private static String[] splitAsRegex(String regex, String input) {
		return input.split("[" + regex + ",:]");
	}
}
