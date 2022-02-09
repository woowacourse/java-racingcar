package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public static int sum(String input) {
    if (input == null || input.equals("")) {
      return 0;
    }
    return addAll(toInteger(split(input)));
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

  public static int[] toInteger(String[] stringNumbers) {
    int[] numbers = new int[stringNumbers.length];
    for(int i=0; i < stringNumbers.length; i++){
      numbers[i] = Integer.parseInt(stringNumbers[i]);
    }
    return numbers;
  }

  public static int addAll(int[] numbers) {
    return Arrays.stream(numbers)
        .sum();
  }
}
