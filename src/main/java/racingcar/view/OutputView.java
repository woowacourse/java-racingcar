package racingcar.view;

import racingcar.vo.RoundResult;
import racingcar.vo.RoundResults;
import racingcar.vo.Winners;

public class OutputView {

  private static final String RACE_RESULT_MESSAGE = "실행 결과";
  private static final String POSITION_BAR = "-";
  private static final String RESULT_DELIMITER = " : ";

  public static void printRaceResult(RoundResults results) {
    System.out.println(RACE_RESULT_MESSAGE);
    while (results.hasResult()) {
      printResult(results.poll());
    }
  }

  private static void printResult(RoundResult result) {
    for (String name : result.getNames()) {
      printResultOne(name, result.getPosition(name));
    }
    System.out.println();
  }

  private static void printResultOne(String name, Integer position) {
    StringBuilder builder = new StringBuilder();
    builder.append(name).append(RESULT_DELIMITER);
    for (int i = 0; i < position; i++) {
      builder.append(POSITION_BAR);
    }
    System.out.println(builder.toString());
  }

  public static void printWinners(Winners winners) {
    System.out.print(winners.toString());
  }
}
