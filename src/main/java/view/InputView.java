package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private final Scanner scanner = new Scanner(System.in);

  public List<String> readCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String[] split = readLine().split(",");
    return Arrays.stream(split)
        .peek(this::validateCarName)
        .collect(Collectors.toList());
  }

  private String readLine() {
    return scanner.next();
  }

  private void validateCarName(String inputCarName) {
    if (inputCarName.length() < 1 || inputCarName.length() > 5) {
      throw new IllegalArgumentException("자동차의 이름의 길이는 1 이상 5 이하여아 한다");
    }
  }

  public int readRoundNum() {
    try {
      System.out.println("시도할 횟수는 몇회인가요?");
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      throw new InputMismatchException("이동 횟수는 숫자여야 합니다.");
    }
  }
}
