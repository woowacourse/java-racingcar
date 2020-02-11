package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 계산 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/11
 */
public class Calculator {
	public static final String DELIMITER = "[,:]";
	public static final String CUSTOM_DELIMITER_PREFIX = "//";
	public static final String CUSTOM_DELIMITER_POSTFIX = "\n";
	public static final int DELIMITER_POSITION = 0;
	public static final int EXPRESSION_POSITION = 1;
	public static final String CUSTOM_DELIMITER_PATTERN = "^(\\/\\/.\n)?\\d+(.\\d+)*\\b";
	public static final String NUMBER_LIST_IS_EMPTY_MESSAGE = "숫자가 한 개 이상 주어져아 합니다.";
	public static final String INVALID_INPUT_MESSAGE = "입력이 유효하지 않습니다.";

	public static int calculate(final List<Integer> numbers) {
		validateNumbers(numbers);
		return numbers.stream()
				.mapToInt(value -> value)
				.reduce(0, Math::addExact);
	}

	private static void validateNumbers(final List<Integer> numbers) {
		Objects.requireNonNull(numbers);
		if (numbers.isEmpty()) {
			throw new IllegalArgumentException(NUMBER_LIST_IS_EMPTY_MESSAGE);
		}
	}

	public static List<Integer> splitByDelimiter(final String input) {
		validateInput(input);
		if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
			String[] splitDelimiter = input.split(CUSTOM_DELIMITER_POSTFIX);
			int delimiterIndex = splitDelimiter[DELIMITER_POSITION].length() - 1;
			String delimiter = String.valueOf(splitDelimiter[DELIMITER_POSITION].charAt(delimiterIndex));
			String expression = splitDelimiter[EXPRESSION_POSITION];
			return splitByDelimiter(expression, delimiter);
		}
		return splitByDelimiter(input, DELIMITER);
	}

	private static void validateInput(String input) {
		if (!Pattern.matches(CUSTOM_DELIMITER_PATTERN, input)) {
			throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
		}
	}

	private static List<Integer> splitByDelimiter(final String input, final String delimiter)
			throws NumberFormatException {
		return Stream.of(input.split(delimiter))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
