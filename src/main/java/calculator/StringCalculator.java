package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

  private final static String START_SIGN_CUSTOMER_DELIMITER = "//";
  private final static String END_SIGN_CUSTOMER_DELIMITER = "\n";
  private final static String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수를 입력할 수 없습니다.";

  public static int splitAndSum(String input) {
    if (isNullOrEmpty(input)) {
      return 0;
    }
    List<Integer> numbers = splitNumbers(input);
    if (containsNegativeNumber(numbers)) {
      throw new IllegalStateException(NEGATIVE_NUMBER_ERROR_MESSAGE);
    }
    return numbers.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }

  private static boolean isNullOrEmpty(String input) {
    return input == null || input.equals("");
  }

  private static boolean containsNegativeNumber(List<Integer> numbers) {
    return numbers.stream()
        .anyMatch(number -> number < 0);
  }

  private static List<Integer> splitNumbers(String input) {
    List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
    if (containsCustomerDelimiter(input)) {
      addCustomerDelimiter(input, delimiters);
      input = input.substring(
          input.indexOf(END_SIGN_CUSTOMER_DELIMITER) + END_SIGN_CUSTOMER_DELIMITER.length());
    }
    String finalDelimiters = String.join("|", delimiters);
    return Arrays.stream(input.split(finalDelimiters))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());
  }

  private static boolean containsCustomerDelimiter(String input) {
    return input.contains(START_SIGN_CUSTOMER_DELIMITER) && input
        .contains(END_SIGN_CUSTOMER_DELIMITER);
  }

  private static void addCustomerDelimiter(String input, List<String> delimiters) {
    String customerDelimiter =
        input.substring(
            input.indexOf(START_SIGN_CUSTOMER_DELIMITER) + START_SIGN_CUSTOMER_DELIMITER.length(),
            input.indexOf(END_SIGN_CUSTOMER_DELIMITER)
        );
    delimiters.add(customerDelimiter);
  }

}
