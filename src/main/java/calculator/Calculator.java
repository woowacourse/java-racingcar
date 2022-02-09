package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public static int sum(String input) {
    if (input == null || input.equals("")) {
      return 0;
    }
    return addAll(toIntegers(split(input)));
  }

  public static String[] split(String input) {
    String delimiter = "";
    Pattern pattern = Pattern.compile("//(.)\n(.*)");
    Matcher matcher = pattern.matcher(input);
    if(matcher.find()){
      delimiter = matcher.group(1);
      input = matcher.group(2);
    }
    return input.split("[,:" + delimiter + "]");
  }

  public static int[] toIntegers(String[] stringNumbers) {
    int[] numbers = new int[stringNumbers.length];
    for (int i = 0; i < stringNumbers.length; i++) {
      numbers[i] = toInteger(stringNumbers[i]);
    }
    return numbers;
  }

  private static int toInteger(String stringNumber) {
    try {
      return Integer.parseInt(stringNumber);
    } catch (NumberFormatException numberFormatException) {
      throw new RuntimeException("숫자가 아닌 입력입니다. 구분자를 이용해서 숫자를 입력해주세요.");
    }
  }

  public static int addAll(int[] numbers) {
    return Arrays.stream(numbers)
        .sum();
  }
}
