package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

  public static final int MAX_TRIAL_DIGIT = 2;
  private final int MIN_CAR_NAME_LENGTH = 1;
  private final int MAX_CAR_NAME_LENGTH = 5;
  private final Scanner scanner = new Scanner(System.in);

  private final Pattern DIGIT = Pattern.compile("[0-9]+");

  public List<String> readCarNames() {
    System.out.println(Messages.INPUT_CAR_NAMES);
    String[] split = readLine().split(",");

    return Arrays.stream(split)
        .peek(this::validateCarName)
        .collect(Collectors.toList());
  }

  private String readLine() {
    return scanner.nextLine();
  }

  private void validateCarName(String inputCarName) {
    if (inputCarName.length() < MIN_CAR_NAME_LENGTH || inputCarName.length() > MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(Messages.ERROR_CAR_NAME_LENGTH);
    }
  }

  public int readTrialNum() {
    System.out.println(Messages.INPUT_TRIAL_NUM);
    String input = readLine();
    validateTrialNum(input);
    return Integer.parseInt(input);
  }

  private void validateTrialNum(String input) {
    validateOnlyNum(input);
    validateTrialMaxNum(input);
  }

  private void validateTrialMaxNum(String input) {
    if(input.length() > MAX_TRIAL_DIGIT){
      throw new IllegalArgumentException(Messages.ERROR_MAX_TRIAL_NUM);
    }
  }

  private void validateOnlyNum(String input) {
    boolean isNumber = !DIGIT.matcher(input).matches();
    if (isNumber) {
      throw new IllegalArgumentException(Messages.ERROR_TRIAL_NOT_NUMBER);
    }
  }
}
