package racingcar.view;

import java.util.List;

public class OutputView {

  private static final String PROGRESS_RESULT = "실행 결과";
  private static final String WINNER_PRINT_FORM = "%s가 최종 우승했습니다.";
  private static final String WINNER_JOIN_DELIMITER = ", ";

  public static void printMessage(final String message) {
    System.out.println(message);
  }

  public static void printStartProgress() {
    System.out.println(PROGRESS_RESULT);
  }

  public static void printProgressResult(final LogToGraph log) {
    System.out.print(log.logGraph());
    System.out.println();
  }

  public static void printWinner(final List<String> winners) {
    System.out.printf(WINNER_PRINT_FORM, String.join(WINNER_JOIN_DELIMITER, winners));
  }

}
