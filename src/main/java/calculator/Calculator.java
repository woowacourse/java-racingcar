package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  private static final int ZERO = 0;
  private static final int FIRST_PATTERN = 1;
  private static final int SECOND_PATTERN = 2;

  private static final String EMPTY_STRING = "";
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final String BASIC_DELIMITER_COMMA = ",";
  private static final String BASIC_DELIMITER_COLON = ":";
  private static final String DELIMITER_FORMAT =
      "[" + BASIC_DELIMITER_COMMA + BASIC_DELIMITER_COLON + "%s]";

  private static final String NONE_INTEGER_ERROR_MESSAGE = "숫자가 아닌 입력입니다. 구분자를 이용해서 숫자를 입력해주세요.";
  private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "음수 값을 입력했습니다. 양수를 입력해주세요.";

  public static int sum(String input) {
    if (validNullOrEmpty(input)) {
      return ZERO;
    }
    return addAll(toIntegers(split(input)));
  }

  private static boolean validNullOrEmpty(String input) {
    return input == null || input.equals(EMPTY_STRING);
  }

  private static String[] split(String input) {
    String delimiter = EMPTY_STRING;
    Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
    if (matcher.find()) {
      delimiter = matcher.group(FIRST_PATTERN);
      input = matcher.group(SECOND_PATTERN);
    }
    return input.split(String.format(DELIMITER_FORMAT, delimiter));
  }

  private static int[] toIntegers(String[] stringNumbers) {
    int[] numbers = new int[stringNumbers.length];
    for (int i = 0; i < stringNumbers.length; i++) {
      int result = toInteger(stringNumbers[i]);
      validNegative(result);
      numbers[i] = result;
    }
    return numbers;
  }

  private static int toInteger(String stringNumber) {
    try {
      return Integer.parseInt(stringNumber);
    } catch (NumberFormatException numberFormatException) {
      throw new RuntimeException(NONE_INTEGER_ERROR_MESSAGE);
    }
  }

  private static void validNegative(int number) {
    if (number < ZERO) {
      throw new RuntimeException(NEGATIVE_VALUE_ERROR_MESSAGE);
    }
  }

  private static int addAll(int[] numbers) {
    return Arrays.stream(numbers)
        .sum();
  }
}
