package racingcar.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  private static String readNextLine() {
    try {
      return SCANNER.nextLine();
    } catch (NoSuchElementException exception) {
      throw new RuntimeException("공백을 입력하셨습니다.");
    }
  }

  public static String requestCarName() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return readNextLine();
  }

  public static String requestAttempt() {
    System.out.println("시도할 회수는 몇회인가요?");
    String attemptInput = readNextLine();
    System.out.println();
    return attemptInput;
  }
}
