package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

  private final Scanner scanner = new Scanner(System.in);

  private final Pattern DIGIT = Pattern.compile("[0-9]+");

  public List<String> readCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String[] split = readLine().split(",");

    return Arrays.stream(split)
        .peek(this::validateCarName)
        .collect(Collectors.toList());
  }

  private String readLine() {
    return scanner.nextLine();
  }

  private void validateCarName(String inputCarName) throws IllegalArgumentException {
    if (inputCarName.length() < 1 || inputCarName.length() > 5) {
      throw new IllegalArgumentException("자동차의 이름의 길이는 1 이상 5 이하여아 한다");
    }
  }

  public int readRoundNum() {
    System.out.println("시도할 횟수는 몇회인가요?");
    String input = readLine();
    if (DIGIT.matcher(input).matches()) {
      return Integer.parseInt(input);
    }
    throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
  }
}
