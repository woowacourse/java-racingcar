package calculator;

public class Calculator {
  public static int sum(String input) {
    if (input == null || input.equals("")) {
      return 0;
    }
    return 0;
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
}
