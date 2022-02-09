package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static final String REGEX = "^//(.*)\n.*";
	public static final String REGEX_DEL = "^//(.*)\n";
	public static final String DEFAULT_DELIMITER = ",|:";
	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String delimiter = DEFAULT_DELIMITER;

		if (Pattern.matches(REGEX, input)) {
			Matcher matcher = Pattern.compile(REGEX_DEL).matcher(input);
			matcher.find();
			String regexPart = matcher.group();
			if (regexPart.length() > 4) {
				throw new RuntimeException("커스텀 구분자는 한 글자여야 합니다.");
			}
			if (regexPart.length() < 4) {
				throw new RuntimeException("커스텀 구분자가 입력되지 않았습니다.");
			}

			char delimiterChar = input.charAt(2);
			if (delimiterChar >= '0' && delimiterChar <= '9') {
				throw new RuntimeException("정수는 커스텀 구분자로 지정할 수 없습니다.");
			}

			delimiter = String.valueOf(input.charAt(2));
			input = input.substring(4);
			System.out.println(input);
		}
		String[] result = input.split(delimiter);

		List<Integer> numbers = new ArrayList<>();
		for (String s : result) {
			try {
				numbers.add(Integer.parseInt(s));
			} catch (NumberFormatException exception) {
				throw new RuntimeException("전달된 배열의 원소는 반드시 숫자여야 합니다.");
			}

		}

		if (numbers.isEmpty()) {
			throw new RuntimeException("전달된 배열에 원소가 없습니다.");
		}

		int sum = 0;
		for (Integer number : numbers) {
			if (number < 0) {
				throw new RuntimeException("음수 값은 포함될 수 없습니다.");
			}

			sum += number;
		}

		return sum;
	}
}
