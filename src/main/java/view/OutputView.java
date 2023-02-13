package view;

import domain.Car;
import java.util.List;

public class OutputView {

  private static final String DELIMITER = ", ";
  private static final String BAR = "-";

  private OutputView() {
  }

  public static void printStart() {
    System.out.println();
    System.out.println("실행 결과");
  }

  public static void printCarStatus(String name, int position) {
    System.out.printf("%s : %s\n", name, toBar(position));
  }

  private static String toBar(int count) {
    return BAR.repeat(count);
  }

  public static void printWinners(List<String> carNames) {
    String result = carNames.get(0);
    boolean isCoWinner = carNames.size() > 1;
    if (isCoWinner) {
      result = String.join(DELIMITER, carNames);
    }
    System.out.printf("%s가 최종 우승했습니다.", result);
  }

  public static void printErrorMessage(Exception exception) {
    System.out.println(exception.getMessage());
  }
}
