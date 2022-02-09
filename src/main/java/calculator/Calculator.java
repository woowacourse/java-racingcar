package calculator;

import java.util.Arrays;

public class Calculator {
  public static int sum(String input) {
    if (input == null || input.equals("")) {
      return 0;
    }
    return addAll(toInteger(split(input)));
  }

  public static String[] split(String input) {
    return input.split("[,:]");
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
