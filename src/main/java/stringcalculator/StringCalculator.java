package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static final String DEFAULT_DELIMITERS = ",|:";
	public static final int DELIMITER_INDEX = 1;
	public static final int INPUT_INDEX = 2;
	public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	public static final String SPECIAL_CUSTOM_DELIMITER_PREFIX = "\\";
	public static final String CUSTOM_DELIMITER_PREFIX = "//";
	public static final String ERROR_NEGATIVE_NUMBER_MESSAGE = "음수의 값이 입력되었습니다. 양수를 입력하세요.";
	public static final String ERROR_NOT_NUMBER_MESSAGE = "숫자 이외의 값이 입력되었습니다. 숫자를 입력하세요.";
	public static final String SPECIAL_CUSTOM_DELIMITERS = "+*^";


	public int splitAndSum(String input) {
		if (validNullOrBlank(input)) {
			return 0;
		}

		if (isCustomInput(input)) {
			String[] numbers = splitCustomDelimiter(input);
			return this.sum(numbers);
		}
		String[] numbers = split(input);
		return this.sum(numbers);
	}

	public String[] split(String input) {
		return input.split(DEFAULT_DELIMITERS);
	}

	public String[] splitCustomDelimiter(String input) {
		Matcher m = getMatcher(input);
		if (!m.find()) {
			throw new RuntimeException();
		}
		String customDelimiter = m.group(DELIMITER_INDEX);
		if (isSpecialDelimiter(customDelimiter)) {
			return m.group(INPUT_INDEX).split(addCustomDelimiterPrefix(customDelimiter));
		}
		return m.group(INPUT_INDEX).split(customDelimiter);
	}

	public int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(this::mapToInt).sum();
	}

	private Matcher getMatcher(String input) {
		return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
	}

	private String addCustomDelimiterPrefix(String customDelimiter) {
		return SPECIAL_CUSTOM_DELIMITER_PREFIX + customDelimiter;
	}

	private boolean isSpecialDelimiter(String customDelimiter) {
		return SPECIAL_CUSTOM_DELIMITERS.contains(customDelimiter);
	}

	public boolean isCustomInput(String input) {
		return input.startsWith(CUSTOM_DELIMITER_PREFIX);
	}

	private boolean validNullOrBlank(String input) {
		return input == null || input.isBlank();
	}

	private int mapToInt(String number) {
		try {
			int i = Integer.parseInt(number);
			if (i < 0) {
				throw new RuntimeException(ERROR_NEGATIVE_NUMBER_MESSAGE);
			}
			return i;
		} catch (NumberFormatException e) {
			throw new RuntimeException(ERROR_NOT_NUMBER_MESSAGE);
		}
	}
}
