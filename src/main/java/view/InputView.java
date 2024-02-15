package view;

import constant.Exception;
import constant.Information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
  private static final String DELIMITER = ",";
  private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

  private final BufferedReader br;

  public InputView() {
    this.br = new BufferedReader(new InputStreamReader(System.in));
  }



  public List<String> inputCarsName() throws IOException {
    System.out.println(Information.INPUT_CAR_NAMES);
    String input = br.readLine();
    validateNullAndBlank(input);
    return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
  }

  private void validateNullAndBlank(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException(Exception.INPUT_NULL_BLANK.toString());
    }
  }

  public int inputTrialCount() throws IOException {
    System.out.println(Information.INPUT_TRIAL_COUNT);
    String input = br.readLine();
    validateNumeric(input);
    return Integer.parseInt(input);
  }

  private void validateNumeric(String input) {
    if (!NUMERIC_PATTERN.matcher(input).matches()) {
      throw new IllegalArgumentException(Exception.INPUT_NUMERIC.toString());
    }
  }
}
